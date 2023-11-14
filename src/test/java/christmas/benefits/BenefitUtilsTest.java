package christmas.benefits;

import christmas.config.ChristmasConfig;
import christmas.manager.ChristmasEventManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BenefitUtilsTest {

    private final ChristmasEventManager christmasEventManager = ChristmasConfig.makeChristmasEventManager();
    BenefitUtils benefitUtils = christmasEventManager.getBenefitUtils();

    @Test
    void calculateExpectedPrice() {
    }

    @Test
    void calculateTotalBenefit() {
    }

    @Test
    void calculateTotalDiscount() {
    }
}