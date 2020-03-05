package com.example.osolapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseManager extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "profil.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseManager(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String tableCreationQuery = "create table test1 (";
        tableCreationQuery += "user text primary key,";
        tableCreationQuery += "name text not null,";
        tableCreationQuery += "email text not null,";
        tableCreationQuery += "password text not null);";

        db.execSQL(tableCreationQuery);
        Log.i("DATABASE", "onCreate invoked");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //fonction pour faire des upgrades, alter, drops... sur la table
    }

    public void InsertUSer(String Name, String User, String mail, String Password){
        Name = Name.replace("'", "''");
        User = User.replace("'", "''");
        mail = mail.replace("'", "''");
        Password = Password.replace("'", "''");
        /*String Osolien2 = "FALSE";
        if (Osolien){
            Osolien2 = "TRUE";
        }
        Osolien2= Osolien2.replace("'", "''");*/
        String insertQuery = "insert into users (user, name, email, password, osolien) values ('";
        insertQuery += User;
        insertQuery += "', '";
        insertQuery += Name;
        insertQuery += "', '";
        insertQuery += mail;
        insertQuery += "', '";
        insertQuery += Password;
        insertQuery += "');";
        Log.i("DATABASE", "Insert not invoked yet");
        this.getWritableDatabase().execSQL(insertQuery);
        Log.i("DATABASE", "Insert invoked");
    }
}
