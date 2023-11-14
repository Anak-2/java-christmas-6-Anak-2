package christmas.view;

import christmas.config.ChristmasConfig;
import christmas.manager.ChristmasEventManager;
import christmas.menu.Menu;
import christmas.menu.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    private List<Order> orders;

    @BeforeEach
    public void setUp() {
        Order order1 = new Order(Menu.SEAFOOD_PASTA, 2);
        Order order2 = new Order(Menu.RED_WINE, 1);
        Order order3 = new Order(Menu.CHOCOLATE_CAKE, 1);

        orders = Arrays.asList(order1, order2, order3);
    }

    @Test
    @DisplayName("날짜 오류 기능 테스트")
    void validDate() {
        String invalidInputDate1 = "a";
        String invalidInputDate2 = "32";
        String invalidInputDate3 = "-1";

        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validDate(invalidInputDate1));
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validDate(invalidInputDate2));
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validDate(invalidInputDate3));
    }

    @Test
    @DisplayName("있는 메뉴인지 검사하는 기능 테스트")
    void validMenu() {

        String validMenu = Menu.BARBECUE_RIBS.getMenuName();
        String invalidMenu1  = "해물파스타";
        String invalidMenu2 = "햄울파스타";
        String duplicatedMenu1 = "해산물파스타";

        assertDoesNotThrow(() -> InputValidator.validMenu(validMenu, orders));
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validMenu(invalidMenu1, orders));
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validMenu(invalidMenu2, orders));
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validMenu(duplicatedMenu1, orders));
    }

    @Test
    @DisplayName("메뉴 개수가 1 ~ 20 사이의 정수인지 검사하는 기능 테스트")
    void validMenuCount() {
        int validMenuCount = 13;
        int invalidMenuCount1 = -1;
        int invalidMenuCount2 = 22;

        assertDoesNotThrow(() -> InputValidator.validMenuCount(validMenuCount));
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validMenuCount(invalidMenuCount1));
        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validMenuCount(invalidMenuCount2));
    }

    @Test
    @DisplayName("모든 메뉴가 음료수일 시 주문 불가")
    void isAllBeverage() {
        Order order1 = new Order(Menu.ZERO_COLA, 2);
        Order order2 = new Order(Menu.RED_WINE, 1);
        Order order3 = new Order(Menu.CHAMPAGNE, 1);
        List<Order> invalidOrder = Arrays.asList(order1, order2, order3);

        assertThrows(IllegalArgumentException.class,
                () -> InputValidator.isAllBeverage(invalidOrder));
    }
}