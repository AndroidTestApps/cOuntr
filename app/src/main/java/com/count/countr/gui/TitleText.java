package com.count.countr.gui;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.GridLayout;
import android.widget.TextView;

public class TitleText extends CountText
{
    public TitleText(Context c, String s)
    {
        super(c);
        TextView tt = getTextView();

        GridLayout.LayoutParams lp = getLayoutParams();
        lp.rowSpec = GridLayout.spec(0);
        lp.columnSpec = GridLayout.spec(0);
        tt.setLayoutParams(lp);

        tt.setTextAppearance(c, android.R.style.TextAppearance_Large);
        tt.setAlpha(1);
        setText(s);
    }

    /**
     * Set the text in the correct style.
     *
     * @param s
     */
    public void setText(String s)
    {
        super.setText(s, Typeface.BOLD);
    }

}
