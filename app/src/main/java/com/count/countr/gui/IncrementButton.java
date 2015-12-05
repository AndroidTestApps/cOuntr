package com.count.countr.gui;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import com.count.countr.CountRow;

public class IncrementButton extends CountButton
{

    public IncrementButton(Context context)
    {
        super(context);

        Button b = this.getButtonInstance();
        setText("+");
        b.setBackgroundColor(Color.parseColor("#a1d20d"));

        GridLayout.LayoutParams lp = getLayoutParams();
        lp.setMargins(0, 20, 0, 0);
        lp.rowSpec = GridLayout.spec(0);
        b.setLayoutParams(lp);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("hfd");

                CountRow row = getCountRowFromButton(view);

                row.increment();

                redraw(view);
            }
        });
    }

}
