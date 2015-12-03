package com.peter.countr;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import com.peter.countr.gui.DayText;
import com.peter.countr.gui.DecrementButton;
import com.peter.countr.gui.IncrementButton;
import com.peter.countr.gui.TitleText;
import com.peter.countr.gui.WeekText;

public class CountRow
{
    private GridLayout g;
    private CountItem countItem;

    public CountRow(Context context, CountItem ci)
    {
        setCountItem(ci);
        g = new GridLayout(context);

        GridLayout.LayoutParams lp = new GridLayout.LayoutParams();
        lp.height = GridLayout.LayoutParams.WRAP_CONTENT;
        lp.width = GridLayout.LayoutParams.MATCH_PARENT;
        lp.setGravity(Gravity.TOP);
        lp.setMargins(10,10,10,10);

        g.setLayoutParams(lp);

        TitleText tt = new TitleText(context, countItem.getTitleString());
        g.addView(tt.getTextView());

        DayText dt = new DayText(context, countItem.getDayString());
        g.addView(dt.getTextView());

        WeekText wt = new WeekText(context, countItem.getWeekString());
        g.addView(wt.getTextView());

        IncrementButton ib = new IncrementButton(context);
        g.addView(ib.getButtonInstance());

        DecrementButton db = new DecrementButton(context);
        g.addView(db.getButtonInstance());


        g.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());

                String[] options = {"Stats", "Rename", "Remove"};
                builder.setItems(options, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // The 'which' argument contains the index position
                                // of the selected item
                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();

                return true;
            }
        });
    }

    /**
     * A wrapper for returning the GridLayout instance.
     *
     * @return
     */
    public GridLayout getGrid()
    {
        return g;
    }

    /**
     * Set the CountItem instance.
     *
     * @param item
     */
    public void setCountItem(CountItem item)
    {
        countItem = item;
    }

    /**
     *
     */
    public void increment()
    {
        countItem.increment();

        updateViewTexts();
    }

    /**
     *
     */
    public void decrement()
    {
        countItem.decrement();

        updateViewTexts();
    }

    /**
     * Update the texts in the view.
     */
    private void updateViewTexts()
    {
        TextView dayView = (TextView) g.getChildAt(1);
        changeText(dayView, countItem.getDayString());

        TextView weekView =(TextView) g.getChildAt(2);
        changeText(weekView, countItem.getWeekString());
    }

    /**
     * Change the text of the day counter.
     *
     * @param string
     * @return String
     */
    private String changeText(TextView view, String string)
    {
        view.setText(string);

        return string;
    }

}
