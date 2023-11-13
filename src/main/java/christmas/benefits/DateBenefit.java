package christmas.benefits;

import christmas.eventdate.EventDateUtils;
import static christmas.eventdate.EventDateConstant.*;
import static christmas.benefits.BenefitConstant.*;

public class DateBenefit {

    private final EventDateUtils eventDateUtils;

    public DateBenefit(EventDateUtils eventDateUtils) {
        this.eventDateUtils = eventDateUtils;
    }

    public int calculateBenefitByDate(int currentDate){
        int diffDays = eventDateUtils.calculateDateDiff(EVENT_START_DATE.getDay(), currentDate);
        return INIT_DATE_BENEFIT.getBenefitAmount() + (diffDays * INCREASE_BENEFIT_BY_DATE.getBenefitAmount());
    }
}
