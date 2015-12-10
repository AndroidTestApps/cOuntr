package com.count.countr.gui;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import com.count.countr.CountRow;
import com.count.countr.R;

public class DecrementButton extends CountButton
{

    public DecrementButton(Context context)
    {
        super(context);

        Button b = this.getButtonInstance();
//        setText("-");
        b.getBackground().setColorFilter(context.getResources().getColor(R.color.button_red), PorterDuff.Mode.MULTIPLY);
        GridLayout.LayoutParams lp = getLayoutParams();
        lp.setMargins(0, 200, 0, 10);
        lp.height = 125;
        b.setLayoutParams(lp);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CountRow row = getCountRowFromButton(view);
                row.decrement();
                redraw(view);
            }
        });

        b.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent ev) {
                if (ev.getAction() == MotionEvent.ACTION_DOWN) {
                    view.performClick();
                }

                return true;
            }
        });
    }

}