package com.peter.countr.gui;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import com.peter.countr.CountItem;
import com.peter.countr.CountRow;

import java.util.ArrayList;

public class DecrementButton extends CountButton
{

    public DecrementButton(Context context)
    {
        super(context);

        Button b = this.getButtonInstance();
        setText("-");
        b.setBackgroundColor(Color.parseColor("#91e0420d"));

        GridLayout.LayoutParams lp = getLayoutParams();
        lp.setMargins(0, 120, 0, 10);
        b.setLayoutParams(lp);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CountRow row = getCountRowFromButton(view);

                row.decrement();

                redraw(view);
            }
        });
    }

}