package christmas.manager;

import christmas.benefits.BenefitUtils;
import christmas.benefits.DateBenefit;
import christmas.benefits.MerchandiseBenefit;
import christmas.benefits.SpecialBenefit;
import christmas.eventdate.EventDateUtils;
import christmas.menu.Order;
import christmas.view.InputValidator;
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

    public ChristmasEventManager() {
        inputView = new InputView();
        eventDateUtils = new EventDateUtils();
        dateBenefit = new DateBenefit(eventDateUtils);
        merchandiseBenefit = new MerchandiseBenefit();
        specialBenefit = new SpecialBenefit(eventDateUtils);
        benefitUtils = new BenefitUtils(dateBenefit, specialBenefit, merchandiseBenefit);
        outputView = new OutputView(benefitUtils);
    }

    public void startChristmasEvent(){
        int userInputDate = inputView.askVisitDate();
        List<Order> userInputMenu = inputView.askMenuAndCount();
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
