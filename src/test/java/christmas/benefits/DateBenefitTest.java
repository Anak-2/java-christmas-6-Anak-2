package christmas.benefits;

import christmas.manager.ChristmasEventManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DateBenefitTest {

    @Test
    @DisplayName("날짜마다 100원씩 증가하는 혜택의 현재 날짜 헤택 계산하는 함수 테스트")
    void calculateBenefitByDate() {
        ChristmasEventManager christmasEventManager = new ChristmasEventManager();
        int currentDate = 25;
        int expectedBenefit = 3400;

        DateBenefit dateBenefit = christmasEventManager.getDateBenefit();
        int actualBenefit = dateBenefit.calculateBenefitByDate(currentDate);
        assertThat(actualBenefit).isEqualTo(expectedBenefit);
    }
}