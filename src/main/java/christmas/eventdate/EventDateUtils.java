package christmas.eventdate;

import java.util.Arrays;
import java.util.List;

import static christmas.global.error.NumberErrorMessage.*;

public class EventDateUtils {

    public int calculateDateDiff(int startDay, int endDay){
        int diffDay = endDay - startDay;
        if(diffDay < 0){
            throw new IllegalArgumentException(LESS_THAN_ZERO.getMessage());
        }
        return diffDay;
    }

    public boolean isChristmasAfter(int day){
        return (day > 25);
    }

    public boolean isWeekend(int day){
        List<Integer> weekends = Arrays.asList(1, 2, 8, 9, 15, 16, 22, 23, 29, 30);
        return weekends.contains(day);
    }

    public boolean isStarMarked(int day){
        List<Integer> starMarkedDays = Arrays.asList(3,10,17,24,25,31);
        return starMarkedDays.contains(day);
    }

    public void isValidDay(int day){
        if(day > 31 || day < 1){
            throw new IllegalArgumentException(OUT_OF_DECEMBER.getMessage());
        }
    }
}
