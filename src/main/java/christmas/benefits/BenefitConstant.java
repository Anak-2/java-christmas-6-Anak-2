package christmas.benefits;

public enum BenefitConstant {
    INIT_DATE_BENEFIT(1000),
    INCREASE_BENEFIT_BY_DATE(100);

    private int benefitAmount;

    BenefitConstant(int benefitAmount){
        this.benefitAmount = benefitAmount;
    }

    public int getBenefitAmount() {
        return benefitAmount;
    }
}
