package com.count.countr.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.count.countr.CountItemActivity;

import java.util.ArrayList;

/**
 *
 */
public class ActivityDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "countr";
    private static final String ACTIVITY_TABLE_NAME = "tblActivity";

    ActivityDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(getCreateString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older books table if existed
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);

        // create fresh books table
        this.onCreate(db);
    }

    /**
     * Get create table SQL
     *
     * @return
     */
    public String getCreateString()
    {
        return "CREATE TABLE " + ACTIVITY_TABLE_NAME + "( " +
                "action_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "item_id INTEGER," +
                "date DATETIME," +
                "action VARCHAR(10)";
    }

    /**
     * Access this database, read rows into CountItem instances, returning an ArrayList of them.
     *
     * @return
     */
    public ArrayList<CountItemActivity> fetchItems()
    {
        ArrayList<CountItemActivity> items = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        String[] selectionArgs = {};

        Cursor cursor = db.query(true, ACTIVITY_TABLE_NAME, selectionArgs, "", selectionArgs, "","","action_id","");

        while (!cursor.isLast()) {
            int id = cursor.getInt(0);
            int itemId = cursor.getInt(1);
            String date = cursor.getString(2);
            String action = cursor.getString(2);

            items.add(getCountItemActivityInstance(id, itemId, date, action));
        }

        cursor.close();

        return items;
    }

    public CountItemActivity getCountItemActivityInstance(int id, int itemId, String date, String action)
    {
        return new CountItemActivity(id, itemId, date, action);
    }

}