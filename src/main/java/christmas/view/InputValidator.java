package christmas.view;

import christmas.eventdate.EventDateUtils;
import christmas.manager.ChristmasEventManager;

public class InputValidator {

    private static final EventDateUtils eventDateUtils = new EventDateUtils();

    // 날짜 오류
    public static void validDate(String inputDate){
        int date = Integer.parseInt(inputDate);
        eventDateUtils.isValidDay(date);
    }

    // 메뉴 오류
    public static void validMenu(String inputMenu){

    }
}
