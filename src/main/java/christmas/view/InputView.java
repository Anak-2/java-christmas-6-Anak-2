package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.menu.Menu;

import java.util.List;

public class InputView {

    private final String ASK_VISIT_DATE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private final String ASK_MENU_AND_COUNT = "주문하실 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    public int askVisitDate(){
        int date = 0;
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

    public String askMenuAndCount(){
        System.out.println(ASK_MENU_AND_COUNT);
        String menuAndCount = Console.readLine();
        System.out.println(menuAndCount);
        return menuAndCount;
    }

    public int parseDate(String inputDate){
        InputValidator.validDate(inputDate);
        return Integer.parseInt(inputDate);
    }

//    public List<Menu> parseMenu(String inputMenu){
//
//    }


}
