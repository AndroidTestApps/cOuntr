package com.count.countr.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 *
 */
public class CountDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "countr";

    private static final String ITEMS_TABLE_NAME = "tblItems";
    private static final String ITEMS_TABLE_CREATE = "CREATE TABLE " + ITEMS_TABLE_NAME + "";

    CountDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ITEMS_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int a, int b) {
    }
}