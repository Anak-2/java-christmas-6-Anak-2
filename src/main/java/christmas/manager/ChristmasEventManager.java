package christmas.manager;

import christmas.benefits.DateBenefit;
import christmas.eventdate.EventDateUtils;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasEventManager {

    private static InputView inputView;
    private static OutputView outputView;
    private static EventDateUtils eventDateUtils;
    private static DateBenefit dateBenefit;

    public ChristmasEventManager() {
        inputView = new InputView();
        outputView = new OutputView();
        eventDateUtils = new EventDateUtils();
        dateBenefit = new DateBenefit(eventDateUtils);
    }

    public void startChristmasEvent(){
        String userInputDate = inputView.askVisitDate();
        String userInputMenu = inputView.askMenuAndCount();
    }

    public InputView getInputView() {
        return inputView;
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
}
