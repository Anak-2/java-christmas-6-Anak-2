package christmas.benefits;

public class BenefitUtils {

    private final int EVENT_TARGET_CONDITION = 10_000;

    public boolean isEventTarget(int totalOrder){
        return (totalOrder >= EVENT_TARGET_CONDITION);
    }
}
