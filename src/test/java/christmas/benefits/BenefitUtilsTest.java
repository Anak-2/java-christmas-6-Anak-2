package christmas.benefits;

import christmas.benefits.constant.BenefitConstant;
import christmas.benefits.utils.BenefitUtils;
import christmas.config.ChristmasConfig;
import christmas.manager.ChristmasEventManager;
import christmas.menu.Menu;
import christmas.menu.Order;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class BenefitUtilsTest {

    private final ChristmasEventManager christmasEventManager = ChristmasConfig.makeChristmasEventManager();
    private List<Order> benefitOrder;
    private List<Order> noBenefitOrder;

    @BeforeEach
    public void setUp() {

        Order order1 = new Order(Menu.SEAFOOD_PASTA, 2);
        Order order2 = new Order(Menu.RED_WINE, 1);
        Order order3 = new Order(Menu.CHOCOLATE_CAKE, 1);
        Order order4 = new Order(Menu.MUSHROOM_SOUP, 1);
        Order order5 = new Order(Menu.ZERO_COLA, 1);

        benefitOrder = Arrays.asList(order1, order2, order3);
        noBenefitOrder = Arrays.asList(order4, order5);
    }

    @Test
    @DisplayName("만원 이상 고객으로 이벤트 대상인지 검사하는 기능 테스트")
    void eventTargetTest() {
        int day = 1;
        BenefitUtils yesBenefit = christmasEventManager.makeBenefitUtils(new AccumulateBenefit());
        BenefitUtils noBenefit = christmasEventManager.makeBenefitUtils(new AccumulateBenefit());

        assertThat(yesBenefit.calculateBenefit(benefitOrder,day).calculateTotalBenefit())
                .isGreaterThan(BenefitConstant.NOTHING.getBenefit());
        assertThat(noBenefit.calculateBenefit(noBenefitOrder,day).calculateTotalBenefit())
                .isEqualTo(BenefitConstant.NOTHING.getBenefit());
    }

    @Test
    @DisplayName("각 할인 혜택이 적용됐나 검사1")
    void eachBenefitTest(){
        int day1 = 1;

        int expectedBenefitDiscount = 30046;
        int expectedTotalDiscount = 5046;

        BenefitUtils benefit1 = christmasEventManager.makeBenefitUtils(new AccumulateBenefit());
        AccumulateBenefit accumulateBenefit1 = benefit1.calculateBenefit(benefitOrder, day1);

        assertThat(accumulateBenefit1.calculateTotalBenefit())
                .isEqualTo(expectedBenefitDiscount);
        assertThat(accumulateBenefit1.checkMerchandiseEvent())
                .isEqualTo(true);
        assertThat(accumulateBenefit1.calculateTotalDiscount())
                .isEqualTo(expectedTotalDiscount);
    }

    @Test
    @DisplayName("각 할인 혜택이 적용됐나 검사2")
    void eachBenefitTest2(){
        int day26 = 26;

        int zero = 0;

        BenefitUtils benefit2 = christmasEventManager.makeBenefitUtils(new AccumulateBenefit());
        AccumulateBenefit accumulateBenefit2 = benefit2.calculateBenefit(noBenefitOrder, day26);

        assertThat(accumulateBenefit2.calculateTotalBenefit())
                .isEqualTo(zero);
        assertThat(accumulateBenefit2.checkMerchandiseEvent())
                .isEqualTo(false);
        assertThat(accumulateBenefit2.calculateTotalDiscount())
                .isEqualTo(zero);
    }

}