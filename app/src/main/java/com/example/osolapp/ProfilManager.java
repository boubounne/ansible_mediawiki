package com.example.osolapp;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

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
            + KEY_PASSWORD_PROFIL + " TEXT, "
            + KEY_OSOLIEN + " BOOLEAN);";
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

        Cursor c = db.rawQuery("SELECT * FROM "+TABLE_NAME + " WHERE " + KEY_ID_PROFIL + "= ?", new String[]{user});
        if (c.moveToFirst()){
            Log.i("found", "ffff");
            String User = c.getString(c.getColumnIndex(KEY_ID_PROFIL));
            String Name = c.getString(c.getColumnIndex(KEY_NAME_PROFIL));
            String Mail = c.getString(c.getColumnIndex(KEY_MAIL_PROFIL));
            String Password = c.getString(c.getColumnIndex(KEY_PASSWORD_PROFIL));
            Boolean Osolien = false;
            Boolean.parseBoolean(c.getString(c.getColumnIndex(KEY_OSOLIEN)));
            if (c.getString(c.getColumnIndex(KEY_OSOLIEN)).equals("1")){
                Osolien = true;
            }
            c.close();
            profil p = new profil(Name, User, Password, Mail, Osolien);
            return p;
        }
        return new profil("", "","","",false);
    }


  /*  public profil getRecherche(String user){
        //select * from profil where name like '%vincent%' or user like '%vincent%' or mail like '%vincent%

        Cursor c = db.rawQuery("SELECT * FROM "+TABLE_NAME + " WHERE " + KEY_ID_PROFIL + "as like ?", new String[]{user},
                ,KEY_NAME_PROFIL+"as like ?", new String[]{user}, KEY_MAIL_PROFIL+"as like ?", new String[]{user});
        if (c.moveToFirst()){
            Log.i("found", "ffff");
            String User = c.getString(c.getColumnIndex(KEY_ID_PROFIL));
            String Name = c.getString(c.getColumnIndex(KEY_NAME_PROFIL));
            String Mail = c.getString(c.getColumnIndex(KEY_MAIL_PROFIL));
            String Password = c.getString(c.getColumnIndex(KEY_PASSWORD_PROFIL));
            Boolean Osolien = false;
            Boolean.parseBoolean(c.getString(c.getColumnIndex(KEY_OSOLIEN)));
            if (c.getString(c.getColumnIndex(KEY_OSOLIEN)).equals("1")){
                Osolien = true;
            }
            c.close();
            profil p = new profil(Name, User, Password, Mail, Osolien);
            return p;
        }
        return new profil("", "","","",false);
    }*/

    public String getPassword(String user){
        Cursor c = db.rawQuery("SELECT password FROM "+TABLE_NAME + " WHERE " + KEY_ID_PROFIL + "= ?", new String[]{user});
        String pass="";
        if (c.moveToFirst()){
            pass=(c.getString(c.getColumnIndex(KEY_PASSWORD_PROFIL)));
            c.close();
        }
        return pass;
    }

    public String getName(String user){
        Cursor c = db.rawQuery("SELECT password FROM "+TABLE_NAME + " WHERE " + KEY_ID_PROFIL + "= ?", new String[]{user});
        String pass="";
        if (c.moveToFirst()){
            pass=(c.getString(c.getColumnIndex(KEY_PASSWORD_PROFIL)));
            c.close();
        }
        return pass;
    }

    public Cursor getProfils(){
        return db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
    }
}