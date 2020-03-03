package com.example.osolapp;

import android.content.Context;

import org.json.JSONArray;

public class Controle {
    private static Controle instance=null;
    private static profil data;
    private static String nomfic ="saveprofil";
    private static AccesLocal accesLocal;
    private static AccesDistant accesDistant;
    private static Context context;


    private Controle() {super();}


    public static final Controle getInstance(Context context){
        if (context != null){
            Controle.context = context;
        }
        if (Controle.instance==null){
            Controle.instance=new Controle();
            //accesLocal = new AccesLocal(contexte);
            accesDistant = new AccesDistant();
            //data=accesLocal.recup();
            accesDistant.envoi("dernier", new JSONArray());

        }
        return Controle.instance;

    }

    public void setProfil(profil data){
        Controle.data = data;
        ((creation_compte)context).recupProfil();
    }

    public String getName(){
        return data.getName();
    }

    public String getUser(){
        return data.getUser();
    }

    public String getMail(){
        return data.getEmail();
    }
    public String getPassword(){
        return data.getPassword();
    }
    public boolean getOsolien(){
        return data.Osolien();
    }



    public  void creerdata(int ID,String name,String user,String password,String Email, Boolean osolien)
    {
        data=new profil(name,user,password,Email,osolien);
        accesDistant.envoi("enreg", data.convertToJSONarray());
    }


}
