package com.example.osolapp;

import android.provider.ContactsContract;

import java.io.Serializable;

public class profil implements Serializable {


    private int ID;
    private String Name;
    private  String User;
    private String Password;
    private String Email;
    private boolean Osolien;

    public profil(int ID,String Name, String User, String Password,String Email, boolean Osolien){
        this.ID=ID;
        this.Name=Name;
        this.User=User;
        this.Password=Password;
        this.Email=Email;
        this.Osolien=Osolien;
    }

    public int getID() {return ID; }

    public String getName() {return Name; }

    public String getUser() {return User; }

    public String getPassword() {return Password; }

    public String getEmail() {return Email; }

    public boolean Osolien() { return Osolien; }
}
