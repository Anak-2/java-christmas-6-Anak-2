package christmas;

import christmas.manager.ChristmasEventManager;

public class Application {

    public static void main(String[] args) {
        ChristmasEventManager christmasEventManager = new ChristmasEventManager();
        christmasEventManager.startChristmasEvent();
    }
}
