package christmas.view;

import christmas.benefits.AccumulateBenefit;
import christmas.benefits.BenefitUtils;
import christmas.benefits.constant.Badge;
import christmas.benefits.constant.BenefitName;
import christmas.benefits.constant.Merchandise;
import christmas.menu.Order;

import java.util.List;
import java.util.Map;

public class OutputView {

    private final BenefitUtils benefitUtils;

    public OutputView(BenefitUtils benefitUtils) {
        this.benefitUtils = benefitUtils;
    }

    public void printEventPlanner(AccumulateBenefit accumulateBenefit, List<Order> orders){
        printOrders(orders);
        printTotalPrice(orders);
        printMerchandise(accumulateBenefit);
        printBenefitDetails(accumulateBenefit);
        printTotalBenefit(accumulateBenefit);
        printExpectedPrice(orders);
        printEventBadge(accumulateBenefit);
    }

    private void printOrders(List<Order> orders){
        System.out.println("<주문 메뉴>");
        for(Order order : orders){
            System.out.println(order.getMenu().getMenuName()+" "+order.getCount()+"개");
        }
        System.out.println();
    }

    private void printTotalPrice(List<Order> orders){
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(Order.totalPrice(orders));
        System.out.println();
    }

    private void printMerchandise(AccumulateBenefit accumulateBenefit){
        System.out.println("<증정 메뉴>");
        if(accumulateBenefit.checkMerchandiseEvent()){
            System.out.println(Merchandise.CHAMPAGNE.getName() + " 1개");
            return;
        }
        System.out.println(Merchandise.NOTHING.getName());
        System.out.println();
    }

    //    혜택 내역 출력
    private void printBenefitDetails(AccumulateBenefit accumulateBenefit){
        System.out.println("<혜택 내역>");
        for (Map.Entry<BenefitName, Integer> entry : accumulateBenefit.getBenefitDiscount().entrySet()) {
            System.out.println(entry.getKey().getName() + ": " + -1*entry.getValue() + "원");
        }
        System.out.println();
    }

    private void printTotalBenefit(AccumulateBenefit accumulateBenefit){
        System.out.println("<총혜택 금액>");
        System.out.println(-1 * accumulateBenefit.calculateTotalBenefit());
        System.out.println();
    }

    private void printExpectedPrice(List<Order> orders){
        int totalPrice = Order.totalPrice(orders);

        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(benefitUtils.calculateExpectedPrice(totalPrice));
        System.out.println();
    }

    private void printEventBadge(AccumulateBenefit accumulateBenefit){
        System.out.println("<12월 이벤트 배지>");
        System.out.println(accumulateBenefit.getBadge());
        System.out.println();
    }
}
