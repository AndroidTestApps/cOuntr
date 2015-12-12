package com.count.countr.gui;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import com.count.countr.Count;
import com.count.countr.CountItem;
import com.count.countr.CountListAdapter;
import com.count.countr.CountRow;
import com.count.countr.db.ItemDatabase;

import java.util.ArrayList;

public abstract class CountButton
{
    private Button b;
    private GridLayout.LayoutParams lp;

    /**
     * @param context
     */
    public CountButton(Context context)
    {
        b = new Button(context);
        b.setPadding(20,50,20,50);
        b.setClickable(true);

        lp = new GridLayout.LayoutParams();
        lp.width = GridLayout.LayoutParams.WRAP_CONTENT;
        lp.height = GridLayout.LayoutParams.WRAP_CONTENT;
        lp.rowSpec = GridLayout.spec(0);
        lp.columnSpec = GridLayout.spec(3);
        b.setLayoutParams(lp);
    }

    /**
     * Take the Button instance and return the CountRow instance.
     *
     * @param view
     * @return
     */
    public CountRow getCountRowFromButton(View view)
    {
        Count context = (Count) view.getContext();

        ArrayList<CountRow> countRows = context.getCountData().getData();

        for (CountRow cr : countRows) {
            if (cr.getGrid() == view.getParent()) {
                return cr;
            }
        }

        // if no CountRow object found, create a stub and return it.
        return new CountRow(context, new CountItem(""));
    }

    /**
     * Notify adapter of data set change.
     *
     * @param view
     */
    public void redraw (View view)
    {
        Count context = (Count) view.getContext();

        CountListAdapter adapter = context.getAdapter();
    }

    /**
     * Get the actual Button instance
     *
     * @return
     */
    public Button getButtonInstance()
    {
        return b;
    }

    /**
     * Get the GridLayout.LayoutParams instance.
     *
     * @return
     */
    public GridLayout.LayoutParams getLayoutParams()
    {
        return lp;
    }

    /**
     * Set the text for the button
     *
     * @param text
     */
    public void setText(String text) {
        SpannableString s = new SpannableString(text);

        s.setSpan(new StyleSpan(Typeface.BOLD), 0, s.length(), 0);

        b.setText(s);
    }

}
