package christmas.benefits;

import christmas.benefits.utils.DateBenefit;
import christmas.config.ChristmasConfig;
import christmas.manager.ChristmasEventManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DateBenefitTest {

    private final ChristmasEventManager christmasEventManager = ChristmasConfig.makeChristmasEventManager();
    private final DateBenefit dateBenefit = christmasEventManager.getDateBenefit();

    @Test
    @DisplayName("날짜마다 100원씩 증가하는 혜택의 현재 날짜 헤택 계산하는 함수 테스트")
    void calculateBenefitByDDay() {
        int currentDate = 25;
        int expectedBenefit = 3400;

        int actualBenefit = dateBenefit.calculateBenefitByDDay(currentDate);
        assertThat(actualBenefit).isEqualTo(expectedBenefit);
    }

    @Test
    void calculateBenefitByWeekend() {

    }

    @Test
    void calculateBenefitByWeekday() {
    }
}