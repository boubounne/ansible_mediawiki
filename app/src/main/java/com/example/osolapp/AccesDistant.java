package com.example.osolapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*public class AccesDistant implements  AsyncResponse {

    private static final String SERVERADDR = "http://172.18.106.193/user_pico/serveur_pico.php";
    private Controle controle;

    public AccesDistant(){
        controle = Controle.getInstance(null);
    }

    @Override
    public void processFinish(String output) {
        Log.d("serveur", "*******"+output);
        String[] message = output.split("%");
        if (message.length > 1){
            if (message[0].equals("enreg")){
                Log.d("enreg", "****************"+message[1]);
            }else {
                if (message[0].equals("dernier")){
                    Log.d("dernier", "****************"+message[1]);
                    try {
                        JSONObject info = new JSONObject(message[1]);
                        String name = info.getString("Name");
                        String user = info.getString("User");
                        String mail = info.getString("Mail");
                        String password = info.getString("Password");
                        String password2 = info.getString("Password2");
                        boolean osolien = info.getBoolean("Osolien");
                        profil data = new profil(name, user, mail, password, osolien);
                        controle.setProfil(data);
                    }
                    catch (JSONException e){
                        Log.d("Erreur!", "Conversion impossible pti con!"+message[1]);
                    }
                }else{
                    if (message[0].equals("Erreur !")){
                        Log.d("Erreur !", "****************"+message[1]);
                    }
                }
            }
        }
    }

    public void envoi(String operation, JSONArray lesDonneesJSON){
        AccesHTTP accesDonnees = new AccesHTTP();
        accesDonnees.delegate = this;
        accesDonnees.addParam("operation", operation);
        accesDonnees.addParam("lesdonnees", lesDonneesJSON.toString());
        accesDonnees.execute(SERVERADDR);
    }
}
*/