package christmas.global.error;

public enum InputErrorMessage {

    NO_EXIST_MENU("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private String message;

    public String getMessage() {
        return message;
    }

    InputErrorMessage(String message){
        this.message = message;
    }
}