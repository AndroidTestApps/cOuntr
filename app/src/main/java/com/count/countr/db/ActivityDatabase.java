package com.count.countr.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 *
 */
public class ActivityDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "countr";
    private static final String ITEMS_TABLE_NAME = "tblActivity";

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
        return "CREATE TABLE " + ITEMS_TABLE_NAME + "( " +
                "action_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "item_id INTEGER," +
                "date DATETIME," +
                "action VARCHAR(10)";
    }

}