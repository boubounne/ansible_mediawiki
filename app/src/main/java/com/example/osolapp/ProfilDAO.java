package com.example.osolapp;

import android.database.sqlite.SQLiteDatabase;

public class ProfilDAO {
    public static final String TABLE_NAME = "Profil";
    public static final String user = "user";
    public static final String name = "name";
    public static final String email = "email";
    public static final String password = "password";
    public static final String osolien = "osolien";
    public static final String CREATE_TABLE_PROFIL = "CREATE TABLE "
            + TABLE_NAME + " ("
            + user + " TEXT primary key, "
            + name + " TEXT, "
            + email + " TEXT, "
            + password + "TEXT, "
            + osolien + "BOOLEAN);";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";

    public void add(profil p){
        String query = "INSERT INTO " + TABLE_NAME + " ("
                +TABLE_NAME + ", "
                +user + ", "
                +name + ", "
                +email + ", "
                +password + ", "
                +osolien + ") VALUES ("
                +p.getName() +", "
                +p.getUser() + ", "
                +p.getEmail() + ", "
                +p.getPassword() + ", "
                +p.getOsolien() + ")";
        /*SQLiteDatabase db = this.open();
        db.execSQL(query);*/
    }

    public void delete(String user){

    }

    public void edit(profil p){

    }



}
