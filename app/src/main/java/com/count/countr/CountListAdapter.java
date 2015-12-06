package com.count.countr;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Custom adapter for rendering CountRow objects.
 */
public class CountListAdapter extends ArrayAdapter<CountRow> {

    private ArrayList<CountRow> items;
    private Context c;

    public CountListAdapter(ArrayList<CountRow> items, Context ctx) {
        super(ctx, R.layout.activity_countr, items);
        this.items = items;
        this.c = ctx;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CountRow cr = items.get(position);

        return cr.getGrid();
    }
}