package christmas.menu;

import java.util.ArrayList;
import java.util.List;

import static christmas.menu.Category.*;

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

    public List<Order> findDesserts(List<Order> orders){
        List<Order> desserts = new ArrayList<>();
        for(Order order : orders){
            if(order.getMenu().getCategory() == DESSERT){
                desserts.add(order);
            }
        }
        return desserts;
    }

    public List<Order> findMainMenus(List<Order> orders){
        List<Order> mainMenus = new ArrayList<>();
        for(Order order : orders){
            if(order.getMenu().getCategory() == MAIN_MENU){
                mainMenus.add(order);
            }
        }
        return mainMenus;
    }

}
