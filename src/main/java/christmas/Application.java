package christmas;

import christmas.config.ChristmasConfig;
import christmas.manager.ChristmasEventManager;

public class Application {

    public static void main(String[] args) {
        ChristmasEventManager christmasEventManager = ChristmasConfig.makeChristmasEventManager();
        christmasEventManager.startChristmasEvent();
    }
}
