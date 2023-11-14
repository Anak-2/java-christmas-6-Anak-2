package christmas.benefits.constant;

public enum Merchandise {
    NOTHING("없음"),
    CHAMPAGNE("샴페인");

    public String getName() {
        return name;
    }

    private String name;

    Merchandise(String name){
        this.name = name;
    }
}
