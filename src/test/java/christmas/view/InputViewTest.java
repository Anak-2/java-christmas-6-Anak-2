package christmas.view;

import christmas.menu.Menu;
import christmas.menu.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @Test
    @DisplayName("주문을 메뉴, 수량으로 분할해서 Order 객체로 반환")
    void parseOrderTest() {
        InputView inputView = new InputView();
        String inputMenu = "해산물파스타-2,레드와인-1,초코케이크-1";

        List<Order> orders = inputView.parseOrder(inputMenu);

        List<Order> expectedOrders = new ArrayList<>();
        expectedOrders.add(new Order(Menu.SEAFOOD_PASTA,2));
        expectedOrders.add(new Order(Menu.RED_WINE,1));
        expectedOrders.add(new Order(Menu.CHOCOLATE_CAKE,1));

        assertEquals(expectedOrders, orders);
    }
}