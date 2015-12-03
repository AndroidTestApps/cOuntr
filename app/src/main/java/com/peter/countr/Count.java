package com.peter.countr;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Layout;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Count extends ActionBarActivity {
    CountData countData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_new_count);

        setTitle("cOuntr");

        countData = new CountData(this);

        renderItems();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_count, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Get the CountData instance.
     *
     * @return
     */
    public CountData getCountData()
    {
        return countData;
    }

    /**
     * Add all CountRow items to the LinearLayout instance
     */
    public void renderItems()
    {
        LinearLayout l = (LinearLayout) findViewById(R.id.scrollview);

        ArrayList<CountRow> items = countData.getData();

        for (CountRow c : items) {
            int gridIndex = l.indexOfChild(c.getGrid());

            if (gridIndex != -1) {
                l.removeViewAt(gridIndex);
            }
        }

        for (CountRow c : items) {
            l.addView(c.getGrid());
        }
    }

    /**
     * Simulate adding a new item.
     */
    public void addNewCountRow(View view)
    {
        if (countData.getData().size() > 15) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setPositiveButton((CharSequence) "Cool", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // User clicked OK button
                }
            });

            builder.setMessage("Hey, it looks like you're counting a lot of things. Take it easy, go for a walk.");

            AlertDialog dialog = builder.create();

            dialog.show();

            return;
        }

        countData.addItem("Another Item", 0, 0);

        renderItems();

    }

}
