package christmas.view;

import christmas.eventdate.EventDateUtils;
import christmas.manager.ChristmasEventManager;
import christmas.menu.Category;
import christmas.menu.Menu;
import christmas.menu.Order;

import java.util.List;

import static christmas.global.error.InputErrorMessage.INVALID_MENU_COUNT;
import static christmas.global.error.InputErrorMessage.NO_ALL_BEVERAGE;

public class InputValidator {

    private static final EventDateUtils eventDateUtils = new EventDateUtils();

    // 날짜 오류
    public static void validDate(String inputDate){
        int date = Integer.parseInt(inputDate);
        eventDateUtils.isValidDay(date);
    }

    // 메뉴 이름 오류
    public static void validMenu(String inputMenu){
        Menu.findMenu(inputMenu);
    }

    // 메뉴 개수 오류
    public static void validMenuCount(int menuCount){
        final int MAX_MENU_COUNT = 20;
        final int MIN_MENU_COUNT = 1;
        if(menuCount < MIN_MENU_COUNT || menuCount > MAX_MENU_COUNT){
            throw new IllegalArgumentException(INVALID_MENU_COUNT.getMessage());
        }
    }

    // 음료수만 주문인지 검사
    public static void isAllBeverage(List<Order> orders){
        for(Order order : orders){
            if(!order.getMenu().getCategory().equals(Category.BEVERAGE)){
                return;
            }
        }
        throw new IllegalArgumentException(NO_ALL_BEVERAGE.getMessage());
    }
}
