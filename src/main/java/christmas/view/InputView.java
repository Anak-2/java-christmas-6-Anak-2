package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final String ASK_VISIT_DATE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    public String askVisitDate(){
        System.out.println(ASK_VISIT_DATE);
        String visitDate = Console.readLine();
        System.out.println(visitDate);
        return visitDate;
    }
}
