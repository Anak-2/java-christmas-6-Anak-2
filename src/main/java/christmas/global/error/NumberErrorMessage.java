package christmas.global.error;

public enum NumberErrorMessage {
    LESS_THAN_ZERO("[ERROR] 값이 0보다 작은 음수입니다."),
    NOT_NUMBER("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    OUT_OF_DECEMBER("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");

    private String message;

    NumberErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
