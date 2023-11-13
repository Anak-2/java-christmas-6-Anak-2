package christmas.view;

import christmas.benefits.AccumulateDiscount;
import christmas.benefits.BenefitUtils;
import christmas.benefits.constant.Badge;
import christmas.menu.Order;

import java.util.List;

public class OutputView {

    private final BenefitUtils benefitUtils;

    public OutputView(BenefitUtils benefitUtils) {
        this.benefitUtils = benefitUtils;
    }

    public void printOrders(List<Order> orders){
        System.out.println("<주문 메뉴>");
        for(Order order : orders){
            System.out.println(order.getMenu()+" "+order.getCount()+"개");
        }
    }

    public void printTotalPrice(List<Order> orders){
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(Order.totalPrice(orders));
    }

    public void printMerchandise(AccumulateDiscount accumulateDiscount){
        System.out.println("<증정 메뉴>");
        if(accumulateDiscount.checkMerchandiseEvent()){
            System.out.println("샴페인 1개");
            return;
        }
        System.out.println("없음");
    }

    //    혜택 내역 출력
    public void printBenefitDetails(AccumulateDiscount accumulateDiscount){

    }

    public void printTotalBenefit(AccumulateDiscount accumulateDiscount){
        System.out.println("<총혜택 금액>");
        System.out.println(-1 * accumulateDiscount.calculateTotalBenefit());
    }

    public void printExpectedPrice(List<Order> orders){
        int totalPrice = Order.totalPrice(orders);

        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(benefitUtils.calculateExpectedPrice(totalPrice));
    }

    public void printEventBadge(AccumulateDiscount accumulateDiscount){
        System.out.println("<12월 이벤트 배지>");
        int totalBenefit = accumulateDiscount.calculateTotalBenefit();
        Badge badge = benefitUtils.calculateBadge(totalBenefit);
        System.out.println(badge.getBadgeName());
    }

}
