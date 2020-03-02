package com.example.osolapp;

import android.content.Context;

import org.json.JSONArray;

public class Controle {
    private static Controle instance=null;
    private static profil data;
    private static String nomfic ="saveprofil";
    private static AccesLocal accesLocal;
    private static AccesDistant accesDistant;


    private Controle() {super();}

    public static final Controle getInstance(Context contexte){
        if (Controle.instance==null){
            Controle.instance=new Controle();
            //accesLocal = new AccesLocal(contexte);
            accesDistant = new AccesDistant();
            //data=accesLocal.recup();
            accesDistant.envoi("dernier", new JSONArray());

        }
        return Controle.instance;

    }

    public  void creerdata(int ID,String name,String user,String password,String Email, Boolean osolien)
    {
        data=new profil(ID,name,user,password,Email,osolien);
        accesLocal.ajout(data);
    }


}
