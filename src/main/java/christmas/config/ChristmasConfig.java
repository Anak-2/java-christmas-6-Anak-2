package christmas.config;

import christmas.manager.ChristmasEventManager;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasConfig {

    public ChristmasConfig(){
    }

    public static ChristmasEventManager initChristmasEventManager(){
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        return new ChristmasEventManager(inputView, outputView);
    }
}
