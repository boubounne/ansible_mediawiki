package com.example.osolapp;

import android.content.Context;
import android.database.Cursor;
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
        String req="insert into Data (Name,User,Password,Osoloen) values ";
        req +="(\""+data.getName()+"\",\""+data.getUser()+"\",\""+data.getPassword()+"\","+data.Osolien()+")";
        bd.execSQL(req);
    }

    public Data recup(){

        bd = accesBD.getReadableDatabase();
        Data data=null;
        String req= "select * from data";
        Cursor curseur= bd.rawQuery(req,null);
        curseur.moveToLast();
        if(!curseur.isAfterLast()){
            String Name=curseur.getString(1);
            String User=curseur.getString(2);
            String Password=curseur.getString(3);
            data=new Data(Name,User,Password,true);
            }
        curseur.close();
        return data;



    }
}
