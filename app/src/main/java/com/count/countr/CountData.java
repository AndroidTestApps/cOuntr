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

        for (CountItem item : loadFromDatabase(c)) {
            items.add(new CountRow(c, item));
        }
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
        ItemDatabase itemsDb = new ItemDatabase(c);

        CountItem ci = itemsDb.addItem(title);

        items.add(new CountRow(c, ci));
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

    /**
     * Take a CountItem object and find it's index in the items array.
     *
     * @param ci
     * @return
     */
    public int findIndexByItem(CountItem ci)
    {
        for (CountRow cr : items) {
            if (cr.getCountItem().equals(ci)) {
                return items.indexOf(cr);
            }
        }

        return -1;
    }
}
