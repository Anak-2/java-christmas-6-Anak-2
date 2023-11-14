package christmas.view;

import christmas.eventdate.EventDateUtils;
import christmas.manager.ChristmasEventManager;
import christmas.menu.Category;
import christmas.menu.Menu;
import christmas.menu.Order;

import java.util.List;

import static christmas.global.error.InputErrorMessage.*;
import static christmas.global.error.NumberErrorMessage.NOT_NUMBER;

public class InputValidator {

    private static final EventDateUtils eventDateUtils = new EventDateUtils();

    // 날짜 오류
    public static int validDate(String inputDate){
        int date;
        try{
            date = Integer.parseInt(inputDate);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
        eventDateUtils.isValidDay(date);
        return date;
    }

    // 메뉴 이름, 중복 오류
    public static Menu validMenu(String inputMenu, List<Order> orders){
        Menu menuInput = Menu.findMenu(inputMenu);
        findDuplicatedMenu(menuInput, orders);
        return menuInput;
    }

    // 메뉴 개수 오류
    public static void validMenuCount(int menuCount){
        final int MAX_MENU_COUNT = 20;
        final int MIN_MENU_COUNT = 1;
        if(menuCount < MIN_MENU_COUNT){
            throw new IllegalArgumentException(INVALID_MENU_COUNT.getMessage());
        }
        if(menuCount > MAX_MENU_COUNT){
            throw new IllegalArgumentException(EXCEED_MAX_MENU_COUNT.getMessage());
        }
    }
    
    // 총 메뉴들의 개수 오류
    public static void validTotalMenuCount(List<Order> orders){
        int totalMenuCount = 0;
        for(Order order : orders){
            totalMenuCount += order.getCount();
        }
        final int MAX_MENU_COUNT = 20;
        if(totalMenuCount > MAX_MENU_COUNT){
            throw new IllegalArgumentException(EXCEED_MAX_MENU_COUNT.getMessage());
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

    // 중복 메뉴 검사
    public static void findDuplicatedMenu(Menu menu, List<Order> orders) {
         Order findOrder = orders.stream()
                .filter(order -> order.getMenu().equals(menu))
                .findFirst()
                .orElse(null);
         if(findOrder != null){
             throw new IllegalArgumentException(DUPLICATED_MENU.getMessage());
         }
    }
}
