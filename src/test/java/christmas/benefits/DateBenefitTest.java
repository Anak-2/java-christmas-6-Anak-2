package christmas.benefits;

import christmas.config.ChristmasConfig;
import christmas.manager.ChristmasEventManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DateBenefitTest {

    private ChristmasEventManager christmasEventManager = ChristmasConfig.makeChristmasEventManager();

    @Test
    @DisplayName("날짜마다 100원씩 증가하는 혜택의 현재 날짜 헤택 계산하는 함수 테스트")
    void calculateBenefitByDDay() {
        int currentDate = 25;
        int expectedBenefit = 3400;
        DateBenefit dateBenefit = christmasEventManager.getDateBenefit();

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