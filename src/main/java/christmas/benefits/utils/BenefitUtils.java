package christmas.benefits.utils;

import christmas.benefits.AccumulateBenefit;
import christmas.benefits.constant.Badge;
import christmas.eventdate.EventDateUtils;
import christmas.menu.Order;
import christmas.view.OutputFormat;

import java.util.List;

import static christmas.benefits.constant.BenefitConstant.CHAMPAGNE;
import static christmas.benefits.constant.BenefitName.*;

public class BenefitUtils {

    private final int EVENT_TARGET_CONDITION = 10_000;
    private final boolean NOT_EVENT_TARGET = false;

    private final DateBenefit dateBenefit;
    private final SpecialBenefit specialBenefit;
    private final MerchandiseBenefit merchandiseBenefit;
    private final AccumulateBenefit accumulateBenefit;

    public BenefitUtils(DateBenefit dateBenefit, SpecialBenefit specialBenefit,
                        MerchandiseBenefit merchandiseBenefit, AccumulateBenefit accumulateBenefit) {
        this.dateBenefit = dateBenefit;
        this.specialBenefit = specialBenefit;
        this.merchandiseBenefit = merchandiseBenefit;
        this.accumulateBenefit = accumulateBenefit;
    }

    public AccumulateBenefit calculateBenefit(List<Order> orders, int day){
        int totalPrice = Order.totalPrice(orders);
        if(!isEventTarget(totalPrice)){
            accumulateBenefit.setEventTarget(NOT_EVENT_TARGET);
            return accumulateBenefit;
        }
        calculateDateBenefit(orders, day);
        calculateMerchandiseBenefit(totalPrice);
        calculateSpecialBenefit(day);
        calculateBadge(calculateTotalBenefit());
        return accumulateBenefit;
    }

    private boolean isEventTarget(int totalOrder){
        return (totalOrder >= EVENT_TARGET_CONDITION);
    }

    private int calculateDateBenefit(List<Order> orders, int day){
        int ddayBenefit = dateBenefit.calculateBenefitByDDay(day);
        accumulateBenefit.accumulate(CHRISTMAS_DDAY, ddayBenefit);
        if(EventDateUtils.isWeekend(day)){
            int weekendBenefit = dateBenefit.calculateBenefitByWeekend(orders);
            accumulateBenefit.accumulate(WEEKEND_DISCOUNT, weekendBenefit);
            return Math.addExact(ddayBenefit, weekendBenefit);
        }
        int weekdayBenefit = dateBenefit.calculateBenefitByWeekday(orders);
        accumulateBenefit.accumulate(WEEKDAY_DISCOUNT, weekdayBenefit);
        return Math.addExact(ddayBenefit, weekdayBenefit);
    }

    private void calculateMerchandiseBenefit(int totalPrice){
        if(merchandiseBenefit.champagneDeserved(totalPrice)){
            accumulateBenefit.accumulate(MERCHANDISE_EVENT, CHAMPAGNE.getBenefit());
        }
    }

    private int calculateSpecialBenefit(int day){
        int specialDiscount = specialBenefit.starMarkedBenefit(day);
        accumulateBenefit.accumulate(SPECIAL_DISCOUNT, specialDiscount);
        return specialDiscount;
    }

    private Badge calculateBadge(int totalBenefit){
        if(totalBenefit >= Badge.SANTA.getRequiredPrice()){
            return accumulateBenefit.giveBadge(Badge.SANTA);
        }
        if(totalBenefit >= Badge.TREE.getRequiredPrice()){
            return accumulateBenefit.giveBadge(Badge.TREE);
        }
        if(totalBenefit >= Badge.STAR.getRequiredPrice()){
            return accumulateBenefit.giveBadge(Badge.STAR);
        }
        return accumulateBenefit.giveBadge(Badge.NOTHING);
    }

    public int calculateExpectedPrice(int totalPrice){
        int totalBenefit = calculateTotalBenefit();
        int merchandiseBenefit = accumulateBenefit.getBenefitDiscount()
                                                .get(MERCHANDISE_EVENT);
        int expectedPrice = Math.subtractExact(totalPrice, totalBenefit);
        expectedPrice = Math.addExact(expectedPrice, merchandiseBenefit);
        return Math.max(expectedPrice, 0);
    }

    public int calculateTotalBenefit(){
        return accumulateBenefit.calculateTotalBenefit();
    }
}
