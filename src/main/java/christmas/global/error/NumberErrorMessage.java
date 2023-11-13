package christmas.global.error;

public enum NumberErrorMessage {
    LESS_THAN_ZERO("[ERROR] 값이 0보다 작은 음수입니다.");

    private String message;

    NumberErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
