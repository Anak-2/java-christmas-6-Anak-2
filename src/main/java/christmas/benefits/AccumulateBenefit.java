package christmas.benefits;

import christmas.benefits.constant.Badge;
import christmas.benefits.constant.BenefitConstant;
import christmas.benefits.constant.BenefitName;

import java.util.HashMap;
import java.util.Map;

public class AccumulateBenefit {

    private Map<BenefitName, Integer> benefitDiscount;
    private Badge badge;

    public AccumulateBenefit() {
        benefitDiscount = new HashMap<>();
        for (BenefitName benefitName : BenefitName.values()) {
            benefitDiscount.put(benefitName, 0);
        }
        badge = Badge.NOTHING;
    }

    public int calculateTotalBenefit() {
        int totalBenefit = 0;
        for (int discount : benefitDiscount.values()) {
            totalBenefit += discount;
        }
        return totalBenefit;
    }

    public int calculateTotalDiscount() {
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

    public Map<BenefitName, Integer> getBenefitDiscount() {
        return benefitDiscount;
    }

    public Badge getBadge() {
        return badge;
    }

    public void accumulate(BenefitName name, int discount) {
        benefitDiscount.put(name, discount);
    }

    public Badge giveBadge(Badge badge) {
        this.badge = badge;
        return badge;
    }

    public boolean checkMerchandiseEvent() {
        int price = benefitDiscount.get(BenefitName.MERCHANDISE_EVENT);
        return (price > BenefitConstant.NOTHING.getBenefit());
    }
}
