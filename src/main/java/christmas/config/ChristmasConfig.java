package christmas.config;

import christmas.manager.ChristmasEventManager;

public class ChristmasConfig {

    private ChristmasConfig(){
    }

    public static ChristmasEventManager makeChristmasEventManager(){
        return new ChristmasEventManager();
    }

}
