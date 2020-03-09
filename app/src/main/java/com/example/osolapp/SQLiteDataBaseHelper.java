package com.example.osolapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.BoringLayout;

public class SQLiteDataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Pico.db";
    public static final String TABLE_NAME = "Profil_table";
    public static final String user = "user";
    public static final String name = "name";
    public static final String email = "email";
    public static final String password = "password";
    public static Boolean osolien;

    public SQLiteDataBaseHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE table " + TABLE_NAME
        + "(user Text PRIMARY KEY, name text, email text, password text, osolien boolean)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVerion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
