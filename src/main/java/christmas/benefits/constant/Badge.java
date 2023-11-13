package christmas.benefits.constant;

public enum Badge {
    STAR(5_000, "스타"),
    TREE(10_000, "트리"),
    SANTA(20_000, "산타"),
    NOTHING(0, "없음");

    private int requiredPrice;
    private String badgeName;

    Badge(int requiredPrice, String badgeName){
        this.requiredPrice = requiredPrice;
        this.badgeName = badgeName;
    }

    public String getBadgeName() {
        return badgeName;
    }

    public int getRequiredPrice() {
        return requiredPrice;
    }
}
