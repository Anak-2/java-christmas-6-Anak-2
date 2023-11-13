package christmas.benefits;

import christmas.menu.Order;

import java.util.List;

public class BenefitUtils {

    private final int EVENT_TARGET_CONDITION = 10_000;

    private final DateBenefit dateBenefit;
    private final SpecialBenefit specialBenefit;
    private final MerchandiseBenefit merchandiseBenefit;

    public BenefitUtils(DateBenefit dateBenefit, SpecialBenefit specialBenefit,
                        MerchandiseBenefit merchandiseBenefit) {
        this.dateBenefit = dateBenefit;
        this.specialBenefit = specialBenefit;
        this.merchandiseBenefit = merchandiseBenefit;
    }

    public boolean isEventTarget(int totalOrder){
        return (totalOrder >= EVENT_TARGET_CONDITION);
    }

    public int calculateBenefit(List<Order> orders, int day){
        int totalPrice = Order.totalPrice(orders);
        // 혜택 대상인지 확인
        if(!isEventTarget(totalPrice)){
            return 0;
        }
        // 날짜 관련 혜택 확인
        int dateBenefit = calculateDateBenefit(orders, day);
        // 증정 혜택 관련 확인
        // 특별 혜택 관련 확인
        // 샴페인 대상인지 확인
        return 0;
    }

    public int calculateDateBenefit(List<Order> orders, int day){
        int dDayBenefit = dateBenefit.calculateBenefitByDDay(day);
        int weekBenefit = dateBenefit.calculateBenefitByWeekend(orders, day);
        return Math.addExact(dDayBenefit, weekBenefit);
    }
}
