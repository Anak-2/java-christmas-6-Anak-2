package christmas.benefits;

import christmas.benefits.utils.DateBenefit;
import christmas.config.ChristmasConfig;
import christmas.manager.ChristmasEventManager;
import christmas.menu.Menu;
import christmas.menu.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DateBenefitTest {

    private final ChristmasEventManager christmasEventManager = ChristmasConfig.makeChristmasEventManager();
    private final DateBenefit dateBenefit = christmasEventManager.getDateBenefit();

    private List<Order> orders;

    @BeforeEach
    public void setUp() {

        Order order1 = new Order(Menu.SEAFOOD_PASTA, 2);
        Order order2 = new Order(Menu.TBONE_STAKE, 1);
        Order order3 = new Order(Menu.CHOCOLATE_CAKE, 2);
        Order order4 = new Order(Menu.ICE_CREAM, 2);
        Order order5 = new Order(Menu.ZERO_COLA, 1);

        orders = Arrays.asList(order1, order2, order3, order4, order5);
    }

    @Test
    @DisplayName("날짜마다 100원씩 증가하는 혜택의 현재 날짜 헤택 계산하는 함수 테스트 (크리스마스 이후)")
    void calculateBenefitByDDay() {
        int currentDate3 = 26;
        int expectedBenefit3 = 0;

        int actualBenefit3 = dateBenefit.calculateBenefitByDDay(currentDate3);

        assertThat(actualBenefit3).isEqualTo(expectedBenefit3);
    }

    @Test
    @DisplayName("날짜마다 100원씩 증가하는 혜택의 현재 날짜 헤택 계산하는 함수 테스트 (크리스마스 당일)")
    void calculateBenefitByDDay2() {
        int currentDate = 25;
        int expectedBenefit = 3400;

        int actualBenefit = dateBenefit.calculateBenefitByDDay(currentDate);

        assertThat(actualBenefit).isEqualTo(expectedBenefit);
    }

    @Test
    @DisplayName("날짜마다 100원씩 증가하는 혜택의 현재 날짜 헤택 계산하는 함수 테스트 (이벤트 시작날)")
    void calculateBenefitByDDay3() {
        int currentDate2 = 1;
        int expectedBenefit2 = 1000;

        int actualBenefit2 = dateBenefit.calculateBenefitByDDay(currentDate2);

        assertThat(actualBenefit2).isEqualTo(expectedBenefit2);
    }

    @Test
    @DisplayName("주말 할인 기능 검사")
    void calculateBenefitByWeekend() {
        int expectedBenefit = 2023 * 3;

        int actualBenefit = dateBenefit.calculateBenefitByWeekend(orders);

        assertThat(actualBenefit).isEqualTo(expectedBenefit);
    }

    @Test
    @DisplayName("평일 할인 기능 검사")
    void calculateBenefitByWeekday() {
        int expectedBenefit = 2023 * 4;

        int actualBenefit = dateBenefit.calculateBenefitByWeekday(orders);

        assertThat(actualBenefit).isEqualTo(expectedBenefit);
    }
}