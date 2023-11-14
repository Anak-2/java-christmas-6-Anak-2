package christmas.view;

public enum OutputFormat {
     ORDER_MENU_TITLE("<주문 메뉴>"),
     TOTAL_PRICE_TITLE("<할인 전 총주문 금액>"),
     MERCHANDISE_TITLE("<증정 메뉴>"),
     BENEFIT_LIST_TITLE("<혜택 내역>"),
     TOTAL_BENEFIT_TITLE("<총혜택 금액>"),
     AFTER_BENEFIT_PRICE_TITLE("<할인 후 예상 결제 금액>"),
     BADGE_TITLE("<12월 이벤트 배지>"),
    ONE("1"),
    COUNT("개");

    private String message;

    OutputFormat(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
