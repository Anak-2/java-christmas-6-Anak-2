package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.menu.Menu;
import christmas.menu.Order;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {

    private final String GREETING_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private final String ASK_VISIT_DATE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private final String ASK_MENU_AND_COUNT = "주문하실 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    public int askVisitDate(){
        int date;
        System.out.println(GREETING_MESSAGE);
        System.out.println(ASK_VISIT_DATE);
        while(true){
            try{
                date = parseDate(Console.readLine());
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        return date;
    }

    public List<Order> askMenuAndCount(){
        System.out.println(ASK_MENU_AND_COUNT);
        String menuAndCount;
        while(true){
            try{
                menuAndCount = Console.readLine();
                return parseOrder(menuAndCount);
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public int parseDate(String inputDate){
        return InputValidator.validDate(inputDate);
    }

    public List<Order> parseOrder(String inputMenu){
        List<String> menus = parseComma(inputMenu);
        List<Order> orders = parseMenuAndCount(menus);
        InputValidator.isAllBeverage(orders);
        return orders;
    }

    public List<String> parseComma(String inputMenus){
        return Arrays.stream(inputMenus.split(",")).toList();
    }

    public List<Order> parseMenuAndCount(List<String> inputMenus){
        final int MENU = 0;
        final int COUNT = 1;
        List<Order> orders = new ArrayList<>();

        for(String menuAndCount : inputMenus){
            List<String> order = Arrays.stream(menuAndCount.split("-")).toList();
            orders.add(new Order(Menu.findMenu(order.get(MENU)), parseMenuCount(order.get(COUNT))));
        }
        return orders;
    }

    public int parseMenuCount(String inputMenuCount){
        int menuCount = Integer.parseInt(inputMenuCount);
        InputValidator.validMenuCount(menuCount);
        return menuCount;
    }
}
