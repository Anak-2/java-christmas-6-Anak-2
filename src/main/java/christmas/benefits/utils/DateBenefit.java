package christmas.benefits.utils;

import christmas.eventdate.EventDateUtils;
import christmas.menu.Order;

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
        List<Order> mainMenus = Order.findMainMenus(orders);
        return Math.multiplyExact(mainMenus.size(), WEEKEND_DISCOUNT.getBenefit());
    }

    public int calculateBenefitByWeekday(List<Order> orders){
        List<Order> desserts = Order.findDesserts(orders);
        return Math.multiplyExact(desserts.size(), WEEKEND_DISCOUNT.getBenefit());
    }
}
