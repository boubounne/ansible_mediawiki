package com.example.osolapp;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ProfilManager {
    private static final String TABLE_NAME = "profil";
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
    private SQLiteDatabase db;
    private MySQLite myBase;

    public ProfilManager(Context context){
        myBase = MySQLite.getInstance(context);
    }

    public void open(){
        db = myBase.getWritableDatabase();
    }

    public void close(){
        db.close();
    }

    public long addProfil(profil p){
        ContentValues values = new ContentValues();
        values.put(KEY_ID_PROFIL, p.getUser());
        values.put(KEY_NAME_PROFIL, p.getName());
        values.put(KEY_MAIL_PROFIL, p.getEmail());
        values.put(KEY_PASSWORD_PROFIL, p.getPassword());
        values.put(KEY_OSOLIEN, p.getOsolien());
        return db.insert(TABLE_NAME, null, values);
    }

    public int deleteProfil(profil p){
        String where = KEY_ID_PROFIL + " = ?";
        String[] whereArgs = {p.getUser()+""};
        return db.delete(TABLE_NAME, where, whereArgs);
    }

    public int editProfil(profil p){
        ContentValues values = new ContentValues();
        values.put(KEY_ID_PROFIL, p.getUser());
        values.put(KEY_NAME_PROFIL, p.getName());
        values.put(KEY_MAIL_PROFIL, p.getEmail());
        values.put(KEY_PASSWORD_PROFIL, p.getPassword());
        values.put(KEY_OSOLIEN, p.getOsolien());
        String where = KEY_ID_PROFIL + " = ?";
        String[] whereArgs = {p.getUser()+""};
        return db.update(TABLE_NAME, values, where, whereArgs);
    }

    public profil getProfil(String user){
        profil p = new profil(user);
        Cursor c = db.rawQuery("SELECT * FROM "+TABLE_NAME + " WHERE " + KEY_ID_PROFIL + "=" + user, null);
        if (c.moveToFirst()){
            p.setUser(c.getString(c.getColumnIndex(KEY_ID_PROFIL)));
            p.setName(c.getString(c.getColumnIndex(KEY_NAME_PROFIL)));
            p.setEmail(c.getString(c.getColumnIndex(KEY_MAIL_PROFIL)));
            p.setPassword(c.getString(c.getColumnIndex(KEY_PASSWORD_PROFIL)));
            p.setOsolien(Boolean.parseBoolean(c.getString(c.getColumnIndex(KEY_OSOLIEN))));
            c.close();

        }
        return p;
    }

    public Cursor getProfils(){
        return db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
    }
}
