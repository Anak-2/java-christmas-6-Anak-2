package christmas.config;

import christmas.benefits.DateBenefit;
import christmas.eventdate.EventDateUtils;
import christmas.manager.ChristmasEventManager;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasConfig {

    public ChristmasConfig(){
    }

    public DateBenefit getDateBenefit(EventDateUtils eventDateUtils){
        return new DateBenefit(eventDateUtils);
    }

    public ChristmasEventManager initChristmasEventManager(){
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        EventDateUtils eventDateUtils = new EventDateUtils();
        DateBenefit dateBenefit = getDateBenefit(eventDateUtils);

        return new ChristmasEventManager();
    }
}
