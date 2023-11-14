package christmas.view;

import christmas.config.ChristmasConfig;
import christmas.manager.ChristmasEventManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    @DisplayName("날짜 오류 기능 테스트")
    void validDate() {
        String invalidInputDate1 = "a";
        String invalidInputDate2 = "32";

        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validDate(invalidInputDate1));
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validDate(invalidInputDate2));
    }

    @Test
    void validMenu() {
    }

    @Test
    void validMenuCount() {
    }

    @Test
    void isAllBeverage() {
    }
}