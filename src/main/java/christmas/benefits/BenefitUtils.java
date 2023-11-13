package christmas.benefits;

import christmas.benefits.constant.Badge;
import christmas.benefits.constant.BenefitConstant;
import christmas.benefits.constant.BenefitName;
import christmas.eventdate.EventDateUtils;
import christmas.menu.Order;

import java.util.List;

import static christmas.benefits.constant.BenefitConstant.CHAMPAGNE;
import static christmas.benefits.constant.BenefitName.*;

public class BenefitUtils {

    private final int EVENT_TARGET_CONDITION = 10_000;

    private final DateBenefit dateBenefit;
    private final SpecialBenefit specialBenefit;
    private final MerchandiseBenefit merchandiseBenefit;

    private AccumulateDiscount accumulateDiscount;

    public BenefitUtils(DateBenefit dateBenefit, SpecialBenefit specialBenefit,
                        MerchandiseBenefit merchandiseBenefit) {
        this.dateBenefit = dateBenefit;
        this.specialBenefit = specialBenefit;
        this.merchandiseBenefit = merchandiseBenefit;
        this.accumulateDiscount = new AccumulateDiscount();
    }

    public AccumulateDiscount calculateBenefit(List<Order> orders, int day){
        int totalPrice = Order.totalPrice(orders);
        if(!isEventTarget(totalPrice)){
            return accumulateDiscount;
        }
        calculateDateBenefit(orders, day);
        calculateMerchandiseBenefit(totalPrice);
        calculateSpecialBenefit(day);
        return accumulateDiscount;
    }

    private boolean isEventTarget(int totalOrder){
        return (totalOrder >= EVENT_TARGET_CONDITION);
    }

    private int calculateDateBenefit(List<Order> orders, int day){
        int ddayBenefit = dateBenefit.calculateBenefitByDDay(day);
        accumulateDiscount.accumulate(CHRISTMAS_DDAY, ddayBenefit);
        if(EventDateUtils.isWeekend(day)){
            int weekendBenefit = dateBenefit.calculateBenefitByWeekend(orders);
            accumulateDiscount.accumulate(WEEKEND_DISCOUNT, weekendBenefit);
            return Math.addExact(ddayBenefit, weekendBenefit);
        }
        int weekdayBenefit = dateBenefit.calculateBenefitByWeekday(orders);
        return Math.addExact(ddayBenefit, weekdayBenefit);
    }

    private void calculateMerchandiseBenefit(int totalPrice){
        if(merchandiseBenefit.champagneDeserved(totalPrice)){
            accumulateDiscount.accumulate(MERCHANDISE_EVENT, CHAMPAGNE.getBenefit());
        }
    }

    private int calculateSpecialBenefit(int day){
        int specialDiscount = specialBenefit.starMarkedBenefit(day);
        accumulateDiscount.accumulate(SPECIAL_DISCOUNT, specialDiscount);
        return specialDiscount;
    }

    public Badge calculateBadge(int totalBenefit){
        if(totalBenefit >= Badge.SANTA.getRequiredPrice()){
            return Badge.SANTA;
        }
        if(totalBenefit >= Badge.TREE.getRequiredPrice()){
            return Badge.TREE;
        }
        if(totalBenefit >= Badge.STAR.getRequiredPrice()){
            return Badge.STAR;
        }
        return Badge.NOTHING;
    }
}
