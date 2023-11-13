package christmas;

import christmas.config.ChristmasConfig;
import christmas.manager.ChristmasEventManager;
import christmas.view.InputView;

public class Application {

    public static void main(String[] args) {
        ChristmasEventManager christmasEventManager = ChristmasConfig.initChristmasEventManager();
        christmasEventManager.startChristmasEvent();
    }
}
