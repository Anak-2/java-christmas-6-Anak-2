package christmas.benefits;

import christmas.eventdate.EventDateUtils;

public class SpecialBenefit {

    private EventDateUtils eventDateUtils;

    public SpecialBenefit(EventDateUtils eventDateUtils) {
        this.eventDateUtils = eventDateUtils;
    }

    public int starMarkedBenefit(int day){
        final int STAR_MARKED_DISCOUNT = 1000;

        if(eventDateUtils.isStarMarked(day));
        return STAR_MARKED_DISCOUNT;
    }
}
