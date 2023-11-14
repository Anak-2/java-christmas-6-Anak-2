package christmas.eventdate;

import christmas.config.ChristmasConfig;
import christmas.manager.ChristmasEventManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventDateUtilsTest {

    private ChristmasEventManager christmasEventManager = ChristmasConfig.makeChristmasEventManager();
    EventDateUtils eventDateUtils = christmasEventManager.getEventDateUtils();

    @Test
    @DisplayName("두 날짜의 차이를 계산하는 기능")
    public void calculateDateDiffTest() {
        int diffDay = eventDateUtils.calculateDateDiff(10, 5);
        assertEquals(5, diffDay);

        assertThrows(IllegalArgumentException.class, () -> {
            eventDateUtils.calculateDateDiff(5, 10);
        });
    }

    @Test
    @DisplayName("크리스마스 이후 날짜인지 검사하는 기능")
    public void isChristmasAfterTest() {
        assertTrue(eventDateUtils.isChristmasAfter(26));
        assertFalse(eventDateUtils.isChristmasAfter(24));
    }

    @Test
    @DisplayName("주말인지 평일인지 검사하는 기능")
    public void isWeekendTest() {
        assertTrue(EventDateUtils.isWeekend(1));
        assertFalse(EventDateUtils.isWeekend(3));
    }

    @Test
    @DisplayName("별표 마크가 된 날짜인지 검사하는 기능")
    public void isStarMarkedTest() {
        assertTrue(eventDateUtils.isStarMarked(3));
        assertFalse(eventDateUtils.isStarMarked(1));
    }

    @Test
    @DisplayName("유효한 날짜인지 검사하는 기능")
    public void isValidDayTest() {
        assertDoesNotThrow(() -> {
            eventDateUtils.isValidDay(1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            eventDateUtils.isValidDay(32);
        });
    }
}