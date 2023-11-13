package christmas.benefits;

import christmas.menu.Order;

import java.util.List;

public class BenefitUtils {

    private final int EVENT_TARGET_CONDITION = 10_000;

    public boolean isEventTarget(int totalOrder){
        return (totalOrder >= EVENT_TARGET_CONDITION);
    }

    public boolean calculateBenefit(List<Order> orders){
        // 혜택 대상인지 확인
        // 날짜 관련 혜택 확인
        // 증정 혜택 관련 확인
        // 특별 혜택 관련 확인
        // 샴페인 대상인지 확인
        return false;
    }
}
