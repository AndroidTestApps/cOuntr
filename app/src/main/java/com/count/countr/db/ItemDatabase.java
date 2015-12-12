package com.count.countr.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.count.countr.CountItem;

import java.util.ArrayList;

/**
 * Database interface to collect rows from tblItems and convert them to CountItem instances.
 */
public class ItemDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "countr";
    private static final String ITEMS_TABLE_NAME = "tblItems";
    private Context c;

    public ItemDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        c = context;
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
        return "CREATE TABLE " + ITEMS_TABLE_NAME + "( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name VARCHAR(255)";
    }

    /**
     * Rename
     *
     * @param id
     * @param name
     */
    public void rename(int id, String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
    }

    /**
     * Access this database, read rows into CountItem instances, returning an ArrayList of them.
     *
     * @return
     */
    public ArrayList<CountItem> fetchItems()
    {
        ArrayList<CountItem> items = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        String[] selectionArgs = {};

        Cursor cursor = db.query(true, ITEMS_TABLE_NAME, selectionArgs, "", selectionArgs, "","","id","");

        while (!cursor.isLast()) {
            int id = cursor.getInt(cursor.getPosition());
            String name = cursor.getString(cursor.getPosition());

            items.add(getCountItemInstance(id, name));
        }

        cursor.close();

        return items;
    }

    /**
     *
     * @param id
     * @param name
     * @return
     */
    private CountItem getCountItemInstance(int id, String name)
    {
        ActivityDatabase count = new ActivityDatabase(c);


        return new CountItem(name);
    }

}