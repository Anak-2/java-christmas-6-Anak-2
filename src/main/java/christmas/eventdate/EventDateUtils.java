package christmas.eventdate;

import java.util.Arrays;
import java.util.List;

import static christmas.global.error.NumberErrorMessage.*;

public class EventDateUtils {

    private static final List<Integer> WEEKEND_DAYS = Arrays.asList(1, 2, 8, 9, 15, 16, 22, 23, 29, 30);
    private static final List<Integer> STAR_MARKED_DAYS = Arrays.asList(3, 10, 17, 24, 25, 31);

    public int calculateDateDiff(int endDay, int startDay){
        int diffDay = endDay - startDay;
        if(diffDay < 0){
            throw new IllegalArgumentException(LESS_THAN_ZERO.getMessage());
        }
        return diffDay;
    }

    public boolean isChristmasAfter(int day){
        return (day > EventDateConstant.CHRISTMAS_DATE.getDay());
    }

    public static boolean isWeekend(int day){
        return WEEKEND_DAYS.contains(day);
    }

    public boolean isStarMarked(int day){
        return STAR_MARKED_DAYS.contains(day);
    }

    public void isValidDay(int day){
        if(day > EventDateConstant.EVENT_LAST_DATE.getDay()
                || day < EventDateConstant.EVENT_START_DATE.getDay()){
            throw new IllegalArgumentException(OUT_OF_DECEMBER.getMessage());
        }
    }
}
