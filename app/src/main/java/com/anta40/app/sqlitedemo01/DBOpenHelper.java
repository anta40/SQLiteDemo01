package com.anta40.app.sqlitedemo01;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DBOpenHelper extends SQLiteAssetHelper {

    private Context ctxt;
    private final static String DB_NAME = "db12345.db";
    private final static int DB_VERSION = 1;
    private SQLiteDatabase db;

    public DBOpenHelper(Context ctxt){
        super(ctxt, DB_NAME, null, DB_VERSION);
    }


}
