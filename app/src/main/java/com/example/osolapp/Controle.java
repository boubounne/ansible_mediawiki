package com.example.osolapp;

import android.content.Context;

import com.example.osolapp.AccesLocal;
import com.example.osolapp.Data;

public class Controle {
    private static Controle instance=null;
    private static Data data;
    private static String nomfic ="saveprofil";
    private static AccesLocal accesLocal;


    private Controle() {super();}

    public static final Controle getInstance(Context contexte){
        if (Controle.instance==null){
            Controle.instance=new Controle();
            accesLocal = new AccesLocal(contexte);
            data=accesLocal.recup();

        }
        return Controle.instance;

    }

    public  void creerdata(String name,String user,String password, Boolean osolien)
    {
        data=new Data(name,user,password,osolien);
        accesLocal.ajout(data);
    }


}
