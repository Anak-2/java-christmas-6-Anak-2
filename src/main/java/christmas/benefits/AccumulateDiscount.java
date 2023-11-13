package christmas.benefits;

import christmas.benefits.constant.BenefitConstant;
import christmas.benefits.constant.BenefitName;
import christmas.benefits.constant.Merchandise;

import java.util.HashMap;
import java.util.Map;

public class AccumulateDiscount {

    private Map<BenefitName, Integer> benefitDiscount;

    public AccumulateDiscount(){
        benefitDiscount = new HashMap<>();
        for (BenefitName benefitName : BenefitName.values()) {
            benefitDiscount.put(benefitName, 0);
        }
    }

    public int calculateTotalBenefit(){
        int totalBenefit = 0;
        for (int discount : benefitDiscount.values()) {
            totalBenefit += discount;
        }
        return totalBenefit;
    }

    public int calculateTotalDiscount(){
        int totalDiscount = 0;
        for (Map.Entry<BenefitName, Integer> entry : benefitDiscount.entrySet()) {
            BenefitName benefitName = entry.getKey();
            int discount = entry.getValue();

            if (benefitName != BenefitName.MERCHANDISE_EVENT) {
                totalDiscount += discount;
            }
        }
        return totalDiscount;
    }

    public void accumulate(BenefitName name, int discount){
        benefitDiscount.put(name, discount);
    }

    public boolean checkMerchandiseEvent(){
        int price = benefitDiscount.get(BenefitName.MERCHANDISE_EVENT);
        return (price > BenefitConstant.NOTHING.getBenefit());
    }
}
