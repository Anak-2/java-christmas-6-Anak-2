package christmas.manager;

import christmas.benefits.*;
import christmas.benefits.utils.BenefitUtils;
import christmas.benefits.utils.DateBenefit;
import christmas.benefits.utils.MerchandiseBenefit;
import christmas.benefits.utils.SpecialBenefit;
import christmas.eventdate.EventDateUtils;
import christmas.menu.Order;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class ChristmasEventManager {

    private static InputView inputView;
    private static OutputView outputView;
    private static EventDateUtils eventDateUtils;
    private static MerchandiseBenefit merchandiseBenefit;
    private static SpecialBenefit specialBenefit;
    private static DateBenefit dateBenefit;
    private static BenefitUtils benefitUtils;
    private static AccumulateBenefit accumulateBenefit;

    private int userInputDate;
    private List<Order> userInputMenu;

    public ChristmasEventManager() {
        inputView = new InputView();
        eventDateUtils = new EventDateUtils();
        accumulateBenefit = new AccumulateBenefit();
        dateBenefit = new DateBenefit(eventDateUtils);
        merchandiseBenefit = new MerchandiseBenefit();
        specialBenefit = new SpecialBenefit(eventDateUtils);
        benefitUtils = new BenefitUtils(dateBenefit, specialBenefit, merchandiseBenefit, accumulateBenefit);
        outputView = new OutputView(benefitUtils);
    }

    public void startChristmasEvent(){
        inputChristmasEventOrder();
        printResultOfChristmasEvent();
    }

    public void inputChristmasEventOrder(){
        userInputDate = inputView.askVisitDate();
        userInputMenu = inputView.askMenuAndCount();
    }

    public void printResultOfChristmasEvent(){
        accumulateBenefit = benefitUtils.calculateBenefit(userInputMenu, userInputDate);
        outputView.printEventPlanner(accumulateBenefit, userInputMenu, userInputDate);
    }


    public InputView getInputView() {
        return new InputView();
    }

    public OutputView getOutputView() {
        return outputView;
    }

    public EventDateUtils getEventDateUtils() {
        return eventDateUtils;
    }

    public DateBenefit getDateBenefit() {
        return dateBenefit;
    }

    public MerchandiseBenefit getMerchandiseBenefit() {
        return merchandiseBenefit;
    }

    public SpecialBenefit getSpecialBenefit() {
        return specialBenefit;
    }

    public BenefitUtils getBenefitUtils() {
        return benefitUtils;
    }
}
