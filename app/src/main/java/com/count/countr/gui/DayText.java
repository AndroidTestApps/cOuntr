package com.count.countr.gui;

import android.content.Context;
import android.graphics.Typeface;
import android.view.animation.Animation;
import android.widget.GridLayout;
import android.widget.TextView;

public class DayText extends CountText
{
    public DayText(Context c, String s)
    {
        super(c);
        TextView tt = getTextView();

        GridLayout.LayoutParams lp = getLayoutParams();
        lp.rowSpec = GridLayout.spec(0);
        lp.columnSpec = GridLayout.spec(0);
        lp.setMargins(0,125,0,0);
        tt.setLayoutParams(lp);
        tt.setTextSize(20);
        tt.setAnimation(new Animation() {
            @Override
            public void startNow() {
                super.startNow();
            }
        });

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
        super.setText(s, Typeface.NORMAL);
    }

}
