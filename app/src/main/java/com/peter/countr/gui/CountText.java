package com.peter.countr.gui;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.Gravity;
import android.widget.GridLayout;
import android.widget.TextView;

public abstract class CountText
{
    private TextView t;
    private GridLayout.LayoutParams lp;

    public CountText(Context context)
    {
        t = new TextView(context);

        lp = new GridLayout.LayoutParams();
        lp.height = GridLayout.LayoutParams.WRAP_CONTENT;
        t.setLayoutParams(lp);

        t.setTextAppearance(context, android.R.style.TextAppearance_Large);
        t.setAlpha(1);

        t.setClickable(true);
    }

    /**
     * Set the text for the TextView
     *
     * @param text
     */
    public void setText(String text, int style) {
        SpannableString s = new SpannableString(text);

        s.setSpan(new StyleSpan(style), 0, s.length(), 0);

        t.setText(s);
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
     * Get the TextView instance.
     *
     * @return
     */
    public TextView getTextView()
    {
        return t;
    }

}
