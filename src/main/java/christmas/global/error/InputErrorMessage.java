package christmas.global.error;

public enum InputErrorMessage {

    NO_EXIST_MENU("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_MENU_COUNT("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    EXCEED_MAX_MENU_COUNT("[ERROR] 한 번 주문 메뉴 최대 개수는 20개입니다. 다시 입력해 주세요"),
    DUPLICATED_MENU("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    NO_ALL_BEVERAGE("[ERROR] 음료만 주문은 불가능합니다. 다시 입력해 주세요.");

    private String message;

    public String getMessage() {
        return message;
    }

    InputErrorMessage(String message){
        this.message = message;
    }
}
