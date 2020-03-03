package com.example.osolapp;

import android.app.LauncherActivity;
import android.provider.ContactsContract;

import org.json.JSONArray;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class profil implements Serializable {


    private int ID;
    private String Name;
    private  String User;
    private String Password;
    private String Email;
    private boolean Osolien;

    public profil(String Name, String User, String Password,String Email, boolean Osolien){

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

    public JSONArray convertToJSONarray(){
        List LaListe = new ArrayList();
        LaListe.add(ID);
        LaListe.add(Name);
        LaListe.add(User);
        LaListe.add(Password);
        LaListe.add(Email);
        LaListe.add(Osolien);
        return new JSONArray(LaListe);
    }
}
