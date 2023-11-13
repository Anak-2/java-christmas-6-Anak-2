package christmas.eventdate;

import static christmas.global.error.NumberErrorMessage.*;

public class EventDateUtils {

    public int calculateDateDiff(int startDay, int endDay){
        int diffDay = startDay - endDay;
        if(diffDay < 0){
            throw new IllegalArgumentException(LESS_THAN_ZERO.getMessage());
        }
        return diffDay;
    }

    public boolean isChristmasAfter(int day){
        return (day > 25);
    }
}
