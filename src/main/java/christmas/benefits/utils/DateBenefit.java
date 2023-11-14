package christmas.benefits.utils;

import christmas.eventdate.EventDateUtils;
import christmas.menu.Order;
import org.mockito.internal.matchers.Or;

import java.util.List;

import static christmas.eventdate.EventDateConstant.*;
import static christmas.benefits.constant.BenefitConstant.*;

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
        int diffDays = eventDateUtils.calculateDateDiff(currentDate, EVENT_START_DATE.getDay());
        return Math.addExact(INIT_DATE_BENEFIT.getBenefit(), (diffDays * INCREASE_BENEFIT_BY_DATE.getBenefit()));
    }

    public int calculateBenefitByWeekend(List<Order> orders){
        int mainMenus = Order.totalCount(Order.findMainMenus(orders));
        return Math.multiplyExact(mainMenus, WEEKEND_DISCOUNT.getBenefit());
    }

    public int calculateBenefitByWeekday(List<Order> orders){
        int desserts = Order.totalCount(Order.findDesserts(orders));
        return Math.multiplyExact(desserts, WEEKEND_DISCOUNT.getBenefit());
    }
}
