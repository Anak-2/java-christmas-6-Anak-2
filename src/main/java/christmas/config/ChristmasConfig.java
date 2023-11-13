package christmas.config;

import christmas.benefits.BenefitUtils;
import christmas.benefits.DateBenefit;
import christmas.benefits.MerchandiseBenefit;
import christmas.benefits.SpecialBenefit;
import christmas.eventdate.EventDateUtils;
import christmas.manager.ChristmasEventManager;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasConfig {

    private ChristmasConfig(){
    }

    public static ChristmasEventManager makeChristmasEventManager(){
        return new ChristmasEventManager();
    }

}
