package com.peter.countr.gui;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import com.peter.countr.Count;
import com.peter.countr.CountItem;
import com.peter.countr.CountRow;

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

        lp = new GridLayout.LayoutParams();
        lp.setGravity(Gravity.RIGHT);
        lp.width = GridLayout.LayoutParams.WRAP_CONTENT;
        lp.height = GridLayout.LayoutParams.WRAP_CONTENT;
        lp.rowSpec = GridLayout.spec(0);
        lp.columnSpec = GridLayout.spec(3);
        b.setLayoutParams(lp);

        b.setClickable(true);
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
