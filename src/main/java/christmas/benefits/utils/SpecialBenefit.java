package christmas.benefits.utils;

import christmas.eventdate.EventDateUtils;

import static christmas.benefits.constant.BenefitConstant.NOTHING;
import static christmas.benefits.constant.BenefitConstant.STAR_MARKED_DISCOUNT;

public class SpecialBenefit {

    private EventDateUtils eventDateUtils;

    public SpecialBenefit(EventDateUtils eventDateUtils) {
        this.eventDateUtils = eventDateUtils;
    }

    public int starMarkedBenefit(int day){
        if(eventDateUtils.isStarMarked(day)){
            return STAR_MARKED_DISCOUNT.getBenefit();
        }
        return NOTHING.getBenefit();
    }
}
