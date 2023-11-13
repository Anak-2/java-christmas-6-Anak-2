package christmas.benefits;

public enum BenefitConstant {
    INIT_DATE_BENEFIT(1000),
    INCREASE_BENEFIT_BY_DATE(100),
    WEEKEND_DISCOUNT(2023),
    STAR_MARKED_DISCOUNT(1000);

    private int benefitAmount;

    BenefitConstant(int benefitAmount){
        this.benefitAmount = benefitAmount;
    }

    public int getBenefit() {
        return benefitAmount;
    }
}
