package com.peter.countr;

/**
 * CountItem class, for holding counts.
 */
public class CountItem {

    private final String dayString = "today";
    private final String weekString = "this week";

    private String titleString;
    private int dayCount;
    private int weekCount;

    public CountItem(String titleString)
    {
        titleString = titleString;
        dayCount = 0;
        weekCount = 0;
    }

    public CountItem(String titleString, int dayCount)
    {
        this.titleString = titleString;
        this.dayCount = dayCount;
        this.weekCount = 0;
    }

    public CountItem(String titleString, int dayCount, int weekCount)
    {
        this.titleString = titleString;
        this.dayCount = dayCount;
        this.weekCount = weekCount;
    }

    /**
     * Accessor for dayCount
     *
     * @return
     */
    public int getDayCount()
    {
        return weekCount;
    }

    /**
     * Accessor for weekCount
     *
     * @return
     */
    public int getWeekCount()
    {
        return weekCount;
    }

    /**
     * Accessor for titleString
     *
     * @return
     */
    public String getTitleString() {
        return titleString;
    }

    /**
     * Returns text to be displayed for day count.
     * @return
     */
    public String getDayString()
    {
        return dayCount + " " + dayString;
    }

    /**
     * Returns text to be displayed for week count.
     *
     * @return
     */
    public String getWeekString()
    {
        return weekCount + " " + weekString;
    }

    /**
     * Public interface for incrementing counter.
     */
    public void increment()
    {
        incrementDayCount();
        incrementWeekCount();
    }

    /**
     * Public interface for incrementing counter.
     */
    public void decrement()
    {
        if (this.dayCount > 0) {
            decrementDayCount();
            decrementWeekCount();
        }
    }

    /**
     * Increment the day's counter.
     */
    private void incrementDayCount()
    {
        this.dayCount += 1;

    }

    /**
     * Increment the week's counter.
     */
    private void incrementWeekCount()
    {
        this.weekCount += 1;
    }

    /**
     * Decrement the day's counter.
     */
    private void decrementDayCount()
    {
        this.dayCount -= 1;
    }

    /**
     * Decrement the week's counter.
     */
    private void decrementWeekCount()
    {
        this.weekCount -= 1;
    }

}
