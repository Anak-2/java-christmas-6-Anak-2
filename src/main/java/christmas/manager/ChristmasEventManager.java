package christmas.manager;

import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasEventManager {

    private final InputView inputView;
    private final OutputView outputView;

    public ChristmasEventManager(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startChristmasEvent(){
        String userInputDate = inputView.askVisitDate();
    }
}
