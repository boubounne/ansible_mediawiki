package com.example.osolapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.osolapp.mySQLiteOpenHelper;

public class AccesLocal {

    private String nomBase ="BDOsol";
    private Integer versionBAse =1;
    private mySQLiteOpenHelper accesBD;
    private SQLiteDatabase bd;

    public AccesLocal(Context contexte){
        accesBD = new mySQLiteOpenHelper(contexte,nomBase, null, versionBAse);
    }

    public void ajout(Data data){
        bd = accesBD.getWritableDatabase();
        String req="insert into Data (Name,User,Password) values ";
        req +="("+data.getName()+","+data.getUser()+","+data.getPassword()+")";
    }


}
