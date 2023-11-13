package christmas.benefits;

import christmas.eventdate.EventDateUtils;
import static christmas.eventdate.EventDateConstant.*;

public class DateBenefit {

    private final EventDateUtils eventDateUtils;

    public DateBenefit(EventDateUtils eventDateUtils) {
        this.eventDateUtils = eventDateUtils;
    }

    public int calculateBenefitByDate(int currentDate){
        int diffDays = eventDateUtils.calculateDateDiff(currentDate, EVENT_LAST_DATE.getDay());
        return 0;
    }
}
