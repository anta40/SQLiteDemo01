package com.anta40.app.sqlitedemo01;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBAccess {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DBAccess instance;

    public DBAccess(Context ctxt){
        openHelper = new DBOpenHelper(ctxt);
    }

    public static DBAccess getInstance(Context ctxt){
        if (instance == null){
            instance = new DBAccess(ctxt);
        }
        return instance;
    }

    public void open(){
        this.db = openHelper.getReadableDatabase();
    }

    public void close(){
        if (db != null){
            db.close();
        }
    }

    public List<String> getKeys(){
        List<String> result = new ArrayList<String>();
        Cursor cursor = db.rawQuery("SELECT aKey FROM tbl1", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            result.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return result;
    }

    public List<String> getValues(){
        List<String> result = new ArrayList<String>();
        Cursor cursor = db.rawQuery("SELECT aValue FROM tbl1", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            result.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return result;
    }
}
