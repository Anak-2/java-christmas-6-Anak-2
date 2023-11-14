package christmas.menu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    Order order1 = new Order(Menu.SEAFOOD_PASTA, 2);
    Order order2 = new Order(Menu.RED_WINE, 1);
    Order order3 = new Order(Menu.CHOCOLATE_CAKE, 1);

    List<Order> orders = Arrays.asList(order1, order2, order3);

    @Test
    @DisplayName("주문에서 디저트 메뉴만 고르는 기능 테스트")
    void findDesserts() {
        List<Order> desserts = Order.findDesserts(orders);

        assertEquals(1, desserts.size());
        assertEquals(Menu.CHOCOLATE_CAKE, desserts.get(0).getMenu());
    }

    @Test
    @DisplayName("주문에서 메인 메뉴만 고르는 기능 테스트")
    void findMainMenus() {
        List<Order> mainMenus = Order.findMainMenus(orders);

        assertEquals(1, mainMenus.size());
        assertEquals(Menu.SEAFOOD_PASTA, mainMenus.get(0).getMenu());
    }

    @Test
    @DisplayName("주문의 총 주문 금액을 계산하는 기능 테스트")
    void totalPrice() {
        int expectedTotalPrice = Menu.SEAFOOD_PASTA.getPrice() * 2+
                                 Menu.RED_WINE.getPrice() +
                                 Menu.CHOCOLATE_CAKE.getPrice();

        int totalPrice = Order.totalPrice(orders);
        assertEquals(expectedTotalPrice, totalPrice);
    }
}