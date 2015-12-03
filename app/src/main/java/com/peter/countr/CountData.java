package com.peter.countr;

import android.content.Context;

import java.util.ArrayList;

/**
 * Class for holding information about each item.
 */
public class CountData
{

    private Context c;
    private ArrayList<CountRow> items;

    public CountData(Context context)
    {
        c = context;
        items = new ArrayList<CountRow>();
        addSampleData();

    }

    private void addSampleData()
    {
        CountItem ci = new CountItem("Glasses of Water", 0, 24);

        CountRow ex = new CountRow(c, ci);

        items.add(ex);
    }

    /**
     * Add a new item to the list.
     *
     * @param title
     * @param dayCount
     * @param weekCount
     */
    public void addItem(String title, int dayCount, int weekCount)
    {
        addSampleData();
    }

    /**
     * Get an array of CountRow items.
     *
     * @return Mock list of CountRow items.
     */
    public ArrayList<CountRow> getData()
    {
        return items;
    }
}
