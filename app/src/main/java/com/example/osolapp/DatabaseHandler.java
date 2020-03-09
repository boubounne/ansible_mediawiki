package com.example.osolapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String TABLE_NAME = "Profil";
    public static final String KEY_ID_PROFIL = "user";
    public static final String KEY_NAME_PROFIL = "name";
    public static final String KEY_MAIL_PROFIL = "email";
    public static final String KEY_PASSWORD_PROFIL = "password";
    public static final String KEY_OSOLIEN = "osolien";
    public static final String CREATE_TABLE_PROFIL = "CREATE TABLE "
            + TABLE_NAME + " ("
            + KEY_ID_PROFIL + " TEXT primary key, "
            + KEY_NAME_PROFIL + " TEXT, "
            + KEY_MAIL_PROFIL + " TEXT, "
            + KEY_PASSWORD_PROFIL + "TEXT, "
            + KEY_OSOLIEN + "BOOLEAN);";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void  onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_TABLE_PROFIL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }


}
