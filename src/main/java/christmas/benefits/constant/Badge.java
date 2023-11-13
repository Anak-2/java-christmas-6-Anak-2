package christmas.benefits.constant;

public enum Badge {
    STAR(5_000),
    TREE(10_000),
    SANTA(20_000),
    NOTHING(0);

    private int requiredPrice;

    Badge(int requiredPrice){
        this.requiredPrice = requiredPrice;
    }

    public int getRequiredPrice() {
        return requiredPrice;
    }
}
