package christmas.eventdate;

public enum EventDate {
    EVENT_START_DAY(12,1),
    CHRISTMAS_DAY(12, 25),
    EVENT_LAST_DAY(12,31);

    private int month;
    private int day;

    EventDate(int month, int day){
        this.month = month;
        this.day = day;
    }


}
