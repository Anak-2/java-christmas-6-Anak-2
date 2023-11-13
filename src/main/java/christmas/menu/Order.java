package christmas.menu;

public class Order {

    private final Menu menu;
    private final int count;

    public Menu getMenu() {
        return menu;
    }

    public int getCount() {
        return count;
    }

    public Order(Menu menu, int count) {
        this.menu = menu;
        this.count = count;
    }

}
