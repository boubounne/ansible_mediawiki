package com.example.osolapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class AccesLocal {

    private String nomBase ="BDOsol";
    private Integer versionBAse =1;
    private mySQLiteOpenHelper accesBD;
    private SQLiteDatabase bd;

    public AccesLocal(Context contexte){
        accesBD = new mySQLiteOpenHelper(contexte,nomBase, null, versionBAse);
    }

    public void ajout(profil data){
        bd = accesBD.getWritableDatabase();
        String req="insert into Data (Name,User,Password,Email,Osoloen) values ";
        req +="(\",\""+data.getName()+"\",\""+data.getUser()+"\","+data.getPassword()+"\",\""+data.getEmail()+"\",\""+data.Osolien()+"\"";
        bd.execSQL(req);
    }

    public profil recup(){

        bd = accesBD.getReadableDatabase();
        profil data=null;
        String req= "select * from profil";
        Cursor curseur= bd.rawQuery(req,null);
        curseur.moveToLast();
        if(!curseur.isAfterLast()){
            int ID=curseur.getInt(0);
            String Name=curseur.getString(1);
            String User=curseur.getString(2);
            String Password=curseur.getString(3);
            String Email=curseur.getString(4);
            boolean Osolien=curseur.getWantsAllOnMoveCalls();
            data=new profil(Name,User,Password,Email,Osolien);
            }
        curseur.close();
        return data;



    }
}
