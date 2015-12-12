package com.count.countr;

import android.content.Context;

import com.count.countr.db.ItemDatabase;

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
        items = new ArrayList<>();
        addSampleData();

        for (CountItem item : loadFromDatabase(c)) {
            items.add(new CountRow(c, item));
        }
    }

    private void addSampleData()
    {
        CountItem water = new CountItem("Glasses of Water", 6, 24);
        CountItem runs = new CountItem(">2km Runs", 1, 2);
        CountItem cigarettes = new CountItem("Cigarettes", 2, 13);

        items.add(new CountRow(c, water));
        items.add(new CountRow(c, runs));
        items.add(new CountRow(c, cigarettes));
    }

    /**
     * Return an array of countItem items from the database.
     *
     * @return
     */
    private ArrayList<CountItem> loadFromDatabase(Context c)
    {
        ItemDatabase itemsDb = new ItemDatabase(c);

        return itemsDb.fetchItems();
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
        items.add(new CountRow(c, new CountItem(title, dayCount, weekCount)));
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
