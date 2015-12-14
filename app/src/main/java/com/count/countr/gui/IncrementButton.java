package com.count.countr.gui;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import com.count.countr.CountRow;
import com.count.countr.R;

import java.util.concurrent.Callable;

public class IncrementButton extends CountButton
{
    public IncrementButton(Context context)
    {
        super(context);

        Button b = this.getButtonInstance();
        setText("+");
        b.getBackground().setColorFilter(context.getResources().getColor(R.color.button_green), PorterDuff.Mode.MULTIPLY);

        GridLayout.LayoutParams lp = getLayoutParams();
        lp.setMargins(0, 20, 0, 0);
        lp.rowSpec = GridLayout.spec(0);
        lp.height = 200;
        b.setLayoutParams(lp);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CountRow row = getCountRowFromButton(view);
                row.increment();
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
