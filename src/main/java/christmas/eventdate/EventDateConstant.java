package christmas.eventdate;

public enum EventDateConstant {
    EVENT_START_DATE(12,1),
    CHRISTMAS_DATE(12, 25),
    EVENT_LAST_DATE(12,31);

    private int month;
    private int day;

    EventDateConstant(int month, int day){
        this.month = month;
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}
