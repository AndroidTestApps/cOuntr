package com.count.countr;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * CountItem class, for holding counts.
 */
public class CountItem {

    private final String dayString = "today";
    private final String weekString = "this week";

    private int id;
    private String titleString;
    private int dayCount;
    private int weekCount;
    private ArrayList<CountItemActivity> activities;

    public CountItem(String titleString) {}

    public CountItem(int id, String titleString)
    {
        activities = new ArrayList<>();
        this.titleString = titleString;
        this.id = id;
        this.weekCount = 0;
    }

    /**
     * Return the unique ID
     *
     * @return
     */
    public int getId()
    {
        return id;
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
     * Add a new activity to the item, and recount the current day / week counts.
     *
     * @param cia
     */
    public void addActivity(CountItemActivity cia)
    {
        activities.add(cia);

        triggerRecount();
    }

    /**
     * Use the ArrayList<CountItemActivity> to tally the day / week counts.
     */
    public void triggerRecount()
    {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

        for (CountItemActivity cia : activities) {
            if (cia.getDate() >= c.getTimeInMillis()) {
                if (cia.getAction() == CountItemActivity.ACTION_INCREMENT) {
                    dayCount++;
                    continue;
                }
                dayCount--;
            }
        }
    }

}