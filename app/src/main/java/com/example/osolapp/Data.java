package com.example.osolapp;

import java.io.Serializable;

public class Data implements Serializable {


    private int ID;
    private String Name;
    private  String User;
    private String Password;
    private boolean Osolien;

    public Data(String Name,String User,String Password,boolean Osolien){
        this.Name=Name;
        this.User=User;
        this.Password=Password;
        this.Osolien=Osolien;
    }

    public String getName() {return Name; }

    public String getUser() {return User; }

    public String getPassword() {return Password; }

    public boolean Osolien() { return Osolien; }
}
