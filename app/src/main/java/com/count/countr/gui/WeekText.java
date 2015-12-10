package com.count.countr.gui;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.GridLayout;
import android.widget.TextView;

public class WeekText extends CountText
{
    public WeekText(Context c, String s)
    {
        super(c);
        TextView tt = getTextView();

        GridLayout.LayoutParams lp = getLayoutParams();
        lp.rowSpec = GridLayout.spec(0);
        lp.columnSpec = GridLayout.spec(0);
        lp.setMargins(0,175,0,0);
        tt.setLayoutParams(lp);
        tt.setTextSize(14);

        tt.setAlpha((float) 0.70);
        setText(s);
    }

    /**
     * Set the text in the correct style.
     *
     * @param s
     */
    public void setText(String s)
    {
        super.setText(s, Typeface.ITALIC);
    }

}
