package com.count.countr;

public class CountItemActivity {
    private int actionId;
    private int itemId;
    private String date;
    private String action;

    /**
     * @param id
     * @param itemId
     * @param date
     * @param action
     */
    public CountItemActivity(int id, int itemId, String date, String action)
    {
        actionId = id;
        this.itemId = itemId;
        this.date = date;
        this.action = action;
    }

    /**
     * Return the unique ID of this action.
     * @return
     */
    public int getId()
    {
        return actionId;
    }

    /**
     * Retrieve the associated item's ID.
     * @return
     */
    public int getItemId()
    {
        return itemId;
    }

    /**
     * Retrieve date of action.
     *
     * @return
     */
    public String getDate()
    {
        return date;
    }
}
