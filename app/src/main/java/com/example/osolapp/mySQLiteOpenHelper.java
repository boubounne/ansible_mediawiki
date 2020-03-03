package com.example.osolapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class mySQLiteOpenHelper extends SQLiteOpenHelper {



    private String creation="create table Data("
        +"Name TEXT NOT NULL,"
        +"User TEXT NOT NULL,"
        +"Password TEXT NOT NULL,"
            +"Email TEXT NOT NULL,"
            +"Osolien BOOL NOT NULL);";

    public mySQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(creation);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
