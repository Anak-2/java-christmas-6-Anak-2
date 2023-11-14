package christmas.view;

import christmas.config.ChristmasConfig;
import christmas.manager.ChristmasEventManager;
import christmas.menu.Menu;
import christmas.menu.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    private final ChristmasEventManager christmasEventManager = ChristmasConfig.makeChristmasEventManager();
    private final InputView inputView = christmasEventManager.getInputView();

    @Test
    @DisplayName("주문을 메뉴, 수량으로 분할해서 Order 객체로 반환")
    void parseOrderTest() {
        String inputMenu = "해산물파스타-2,레드와인-1,초코케이크-1";

        List<Order> orders = inputView.parseOrder(inputMenu);

        List<Order> expectedOrders = new ArrayList<>();
        expectedOrders.add(new Order(Menu.SEAFOOD_PASTA,2));
        expectedOrders.add(new Order(Menu.RED_WINE,1));
        expectedOrders.add(new Order(Menu.CHOCOLATE_CAKE,1));

        assertEquals(expectedOrders, orders);
    }

    @Test
    @DisplayName("주문을 이상하게 받았을 때 예외 호출")
    void parseOrderErrorTest(){
        String inputMenu = "해산물파스타2,레드와인-1,초코케이크-1";

        assertThrows(IllegalArgumentException.class, () -> {
            inputView.parseOrder(inputMenu);
        });
    }

    @Test
    @DisplayName("없는 메뉴나 카테고리를 받았을 때 예외 호출")
    void parseOrderNoCategoryTest(){
        String inputMenu = "맛있는파스타-2,레드와인-1,초코케이크-1";

        assertThrows(IllegalArgumentException.class, () -> {
            inputView.parseOrder(inputMenu);
        });
    }
}