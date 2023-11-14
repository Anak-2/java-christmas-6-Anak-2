package christmas.view;

import christmas.benefits.AccumulateBenefit;
import christmas.benefits.utils.BenefitUtils;
import christmas.benefits.constant.BenefitConstant;
import christmas.benefits.constant.BenefitName;
import christmas.benefits.constant.Merchandise;
import christmas.menu.Order;

import java.util.List;
import java.util.Map;

import static christmas.view.OutputFormat.*;

public class OutputView {

    private final BenefitUtils benefitUtils;
    private final String WON = "원";
    private final String NEXT_LINE = "\n";
    private final String SPACE = " ";

    public OutputView(BenefitUtils benefitUtils) {
        this.benefitUtils = benefitUtils;
    }

    public void printEventPlanner(AccumulateBenefit accumulateBenefit, List<Order> orders, int orderDay){
        printShowEventBenefit(orderDay);
        printOrders(orders);
        printTotalPrice(orders);
        printMerchandise(accumulateBenefit);
        printBenefitDetails(accumulateBenefit);
        printTotalBenefit(accumulateBenefit);
        printExpectedPrice(orders);
        printEventBadge(accumulateBenefit);
    }

    private void printShowEventBenefit(int orderDay){
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n"+NEXT_LINE, orderDay);
    }

    private void printOrders(List<Order> orders){
        System.out.println(ORDER_MENU_TITLE.getMessage());
        for(Order order : orders){
            System.out.println(order.getMenu().getMenuName()+SPACE+order.getCount()+COUNT.getMessage());
        }
        System.out.println();
    }

    private void printTotalPrice(List<Order> orders){
        System.out.println(TOTAL_PRICE_TITLE.getMessage());
        System.out.println(Order.totalPrice(orders)+WON);
        System.out.println();
    }

    private void printMerchandise(AccumulateBenefit accumulateBenefit){
        System.out.println(MERCHANDISE_TITLE.getMessage());
        if(accumulateBenefit.checkMerchandiseEvent()){
            System.out.println(Merchandise.CHAMPAGNE.getName()
                    +SPACE+ONE.getMessage()+COUNT.getMessage()+NEXT_LINE);
            return;
        }
        System.out.println(Merchandise.NOTHING.getName()+NEXT_LINE);
    }

    //    혜택 내역 출력
    private void printBenefitDetails(AccumulateBenefit accumulateBenefit){
        System.out.println(BENEFIT_LIST_TITLE.getMessage());
        boolean NO_BENEFIT = true;
        for (Map.Entry<BenefitName, Integer> entry : accumulateBenefit.getBenefitDiscount().entrySet()) {
            if(entry.getValue() == BenefitConstant.NOTHING.getBenefit()){
                continue;
            }
            NO_BENEFIT = false;
            System.out.println(entry.getKey().getName() + ": " + convertToMinus(entry.getValue()) + WON);
        }
        if(NO_BENEFIT){
            System.out.println(BenefitName.NO_BENEFIT.getName());
        }
        System.out.println();
    }

    private void printTotalBenefit(AccumulateBenefit accumulateBenefit){
        System.out.println(TOTAL_BENEFIT_TITLE.getMessage());
        System.out.println(convertToMinus(accumulateBenefit.calculateTotalBenefit())+WON+NEXT_LINE);
    }

    private void printExpectedPrice(List<Order> orders){
        int totalPrice = Order.totalPrice(orders);

        System.out.println(AFTER_BENEFIT_PRICE_TITLE.getMessage());
        System.out.println(benefitUtils.calculateExpectedPrice(totalPrice)+WON+NEXT_LINE);
    }

    private void printEventBadge(AccumulateBenefit accumulateBenefit){
        System.out.println(BADGE_TITLE.getMessage());
        System.out.println(accumulateBenefit.getBadge().getBadgeName());
    }

    private int convertToMinus(int plus){
        return plus * -1;
    }
}
