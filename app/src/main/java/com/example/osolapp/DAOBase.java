package com.example.osolapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public abstract class DAOBase {
    protected final static int VERSION = 1;
    protected final static String TABLE_NAME = "Pico.db";
    protected SQLiteDatabase profilDB = null;
    protected DatabaseHandler profilHandler = null;

    public DAOBase(Context context){
        this.profilHandler = new DatabaseHandler(context, TABLE_NAME, null, VERSION);
    }

    public SQLiteDatabase open()
    {
        profilDB = profilHandler.getWritableDatabase();
        return profilDB;
    }

    public void close(){
        profilDB.close();
    }

    public SQLiteDatabase getDB(){
        return profilDB;
    }
}
