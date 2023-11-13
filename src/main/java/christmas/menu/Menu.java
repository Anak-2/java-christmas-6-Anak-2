package christmas.menu;

import static christmas.global.error.InputErrorMessage.NO_EXIST_MENU;
import static christmas.menu.Category.*;

public enum Menu {
    MUSHROOM_SOUP(APPETIZER, "양송이수프",6_000),
    TAPAS(APPETIZER, "타파스",5_500),
    CAESAR_SALAD(APPETIZER, "시저샐러드",8_000),
    TBONE_STAKE(MAIN_MENU, "티본스테이크",55_000),
    BARBECUE_RIBS(MAIN_MENU, "바비큐립",54_000),
    SEAFOOD_PASTA(MAIN_MENU, "해산물파스타",35_000),
    CHRISTMAS_PASTA(MAIN_MENU, "크리스마스파스타",25_000),
    CHOCOLATE_CAKE(DESSERT, "초코케이크",15_000),
    ICE_CREAM(DESSERT,"아이스크림",5_000),
    ZERO_COLA(DESSERT,"제로콜라",3_000),
    RED_WINE(BEVERAGE,"레드와인",60_000),
    CHAMPAGNE(BEVERAGE,"샴페인",25_000);

    private final Category category;
    private final String menu;
    private final int price;

    Menu(Category category, String menu, int price) {
        this.category = category;
        this.menu = menu;
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public String getMenu() {
        return menu;
    }

    public int getPrice() {
        return price;
    }

    public static boolean isMenuExist(String menuName) {
        for (Menu menu : Menu.values()) {
            if (menu.getMenu().equals(menuName)) {
                return true;
            }
        }
        throw new IllegalArgumentException(NO_EXIST_MENU.getMessage());
    }
}