package com.count.countr;

public class CountItemActivity {
    final public static int ACTION_INCREMENT = 1;
    final public static int ACTION_DECREMENT = 1;

    private int actionId;
    private int itemId;
    private long date;
    private int action;

    /**
     * @param id
     * @param itemId
     * @param date
     * @param action
     */
    public CountItemActivity(int id, int itemId, long date, int action)
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
    public long getDate()
    {
        return date;
    }

    public int getAction()
    {
        return action;
    }
}
