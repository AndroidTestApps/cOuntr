package com.peter.countr;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ListView;

import com.peter.countr.settings.Settings;

public class Count extends ActionBarActivity {
    CountData countData;
    ListView list;
    CountListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_new_count);

        list = (ListView) findViewById(R.id.list);

        countData = new CountData(this);

        setTitle("cOuntr");

        adapter = new CountListAdapter(countData.getData(), this);

        list.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_count, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent k = new Intent(this, Settings.class);
            startActivity(k);

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
     * Get the custom ListAdapter instance.
     *
     * @return
     */
    public CountListAdapter getAdapter()
    {
        return adapter;
    }

    /**
     * Simulate adding a new item.
     *
     * @param
     */
    public void showNewItemModal(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // show an error if adding more than 10 items.
        if (countData.getData().size() > 10) {
            builder.setPositiveButton((CharSequence) "Cool", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // close popup.
                }
            });

            builder.setMessage("Hey, it looks like you're counting a lot of things. Take it easy, go for a walk.");

            AlertDialog dialog = builder.create();

            dialog.show();

            return;
        }

        // find the user input GridLayout and inflate
        LayoutInflater li = (LayoutInflater) view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final GridLayout g = (GridLayout) li.inflate(R.layout.add_new_entry, null);
        final EditText input = (EditText) g.getChildAt(1);
        builder.setView(g);

        // observe key strokes and disable / enable button if there is at least one character.
        input.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {String itemString = input.getText().toString();
                Button b = (Button) g.getChildAt(2);

                if (itemString.length() > 0) {
                    b.setClickable(true);
                    b.setBackgroundColor(Color.parseColor("#a1d20d"));
                } else {
                    b.setClickable(false);
                    b.setBackgroundColor(Color.parseColor("#91e0420d"));
                }

                return false;
            }
        });

        final AlertDialog dialog = builder.create();

        dialog.show();

        // check for the 'Create' button submission.
        Button b = (Button) g.getChildAt(2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemString = input.getText().toString();
                dialog.hide();
                input.setText((CharSequence) "");
                countData.addItem(itemString, 0, 0);
                adapter.notifyDataSetChanged();
            }
        });

        b.setClickable(false);
        b.setBackgroundColor(Color.parseColor("#91e0420d"));
    }

}
