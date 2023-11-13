package christmas.benefits;

import christmas.eventdate.EventDateUtils;
import christmas.menu.Order;

import java.util.List;

import static christmas.eventdate.EventDateConstant.*;
import static christmas.benefits.BenefitConstant.*;

public class DateBenefit {

    private final EventDateUtils eventDateUtils;

    public DateBenefit(EventDateUtils eventDateUtils) {
        this.eventDateUtils = eventDateUtils;
    }

    public int calculateBenefitByDDay(int currentDate){
        int benefit = 0;
        if(eventDateUtils.isChristmasAfter(currentDate)){
            return benefit;
        }
        int diffDays = eventDateUtils.calculateDateDiff(CHRISTMAS_DATE.getDay(), currentDate);
        return INIT_DATE_BENEFIT.getBenefitAmount() + (diffDays * INCREASE_BENEFIT_BY_DATE.getBenefitAmount());
    }

    public int calculateBenefitByWeekend(List<Order> orders, int currentDate){
        if(eventDateUtils.isWeekend(currentDate)){

        }
        return 0;
    }
}
