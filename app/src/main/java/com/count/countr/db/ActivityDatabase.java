package com.count.countr.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.count.countr.CountItem;
import com.count.countr.CountItemActivity;

import java.util.ArrayList;

/**
 *
 */
public class ActivityDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "countr";
    private static final String ACTIVITY_TABLE_NAME = "tblActivity";

    public ActivityDatabase(Context context) {
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
    public static String getCreateString()
    {
        return "CREATE TABLE " + ACTIVITY_TABLE_NAME + "( " +
                "action_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "item_id INTEGER," +
                "date DATETIME," +
                "action VARCHAR(10)" +
                ");";
    }

    /**
     * Access this database, read rows into CountItem instances, returning an ArrayList of them.
     * Only select items which relate to a specific CountItem ID.
     *
     * @return
     */
    public ArrayList<CountItemActivity> fetchItems(int itemId)
    {
        ArrayList<CountItemActivity> items = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {};
        String[] selectionArgs = {"item_id = " + itemId};

        Cursor cursor = db.query(true, ACTIVITY_TABLE_NAME, columns, "", selectionArgs, "","","action_id","");

        while (cursor.getCount() > 0 && !cursor.isLast()) {
            if (cursor.isBeforeFirst()) {
                cursor.moveToNext();
                continue;
            }

            int id = cursor.getInt(0);
            long date = cursor.getLong(2);
            int action = cursor.getInt(2);

            items.add(getCountItemActivityInstance(id, itemId, date, action));

            cursor.moveToNext();
        }

        cursor.close();

        return items;
    }

    public CountItemActivity getCountItemActivityInstance(int id, int itemId, long date, int action)
    {
        return new CountItemActivity(id, itemId, date, action);
    }

    /**
     * Increment the provided CountItem object in the tblActivity table.
     *
     * @param ci
     */
    public CountItemActivity newIncrementActivity(CountItem ci)
    {
        return changeCount(ci, CountItemActivity.ACTION_INCREMENT);
    }

    /**
     * Decrement the provided CountItem object in the tblActivity table
     *
     * @param ci
     * @return
     */
    public CountItemActivity newDecrementActivity(CountItem ci)
    {
        return changeCount(ci, CountItemActivity.ACTION_DECREMENT);
    }

    /**
     * Update the tblActivity table with a new entry to either increment or decrement the counter.
     * @param ci
     * @param value
     * @return
     */
    private CountItemActivity changeCount(CountItem ci, int value)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("item_id", ci.getId());
        values.put("action", value);

        int newId = (int) db.insert(ACTIVITY_TABLE_NAME, null, values);

        return getCountItemActivityInstance(newId, ci.getId(), System.currentTimeMillis(), value);
    }

}