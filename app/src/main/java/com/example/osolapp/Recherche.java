package com.example.osolapp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;



public class Recherche extends AppCompatActivity {

    private static final int NEXT_REQUEST_CODE=0;
    public static final String IS_SHOWN = "IS_SHOWN";
    private boolean isShown = true;
    Button button;
    EditText user;
    EditText mdp;
    ProfilManager pm = new ProfilManager(this);
    String mot_de_passe;
    String utili;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche);
        button=findViewById(R.id.bt);
        user=findViewById(R.id.user5);
        mdp=findViewById(R.id.password5);
        ImageButton btt1;
        ImageButton btt2;
        ImageButton btt3;





        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utili=user.getText().toString();
                pm.open();
                profil p=pm.getProfil(utili);
                pm.close();
                mot_de_passe=mdp.getText().toString();
                if(mot_de_passe.equals("") || utili.equals("")) {
                    Toast.makeText(Recherche.this, "nom d'utilisateur et/ou mot de passe absent",
                            Toast.LENGTH_LONG).show();
                }else {
                    if (p.getOsolien()){
                        if (p.getPassword().equals(mot_de_passe)) {
                            Intent intent = new Intent(Recherche.this, DataView.class);
                            intent.putExtra(IS_SHOWN, isShown);
                            startActivity(intent);
                        } else {

                            Toast.makeText(Recherche.this, "nom d'utilisateur et/ou mot de passe incorrect",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                    else {
                        Toast.makeText(Recherche.this, "vous n'êtes pas un utilisateur osolien",
                                Toast.LENGTH_LONG).show();
                    }

                }
            }
        });

        btt1=findViewById(R.id.imageBt1);
        btt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Recherche.this, "Retour au menu principal",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Recherche.this,MainActivity.class );
                intent.putExtra(IS_SHOWN, isShown);
                startActivity(intent);
            }
        });


        btt2=findViewById(R.id.imageButton5);
        btt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Recherche.this,connect.class );
                intent.putExtra(IS_SHOWN, isShown);
                startActivity(intent);
            }
        });

        btt3=findViewById(R.id.imageBt3);
        btt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Recherche.this, "Description de OSol et Pico",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Recherche.this,description.class);
                intent.putExtra(IS_SHOWN,isShown);
                startActivity(intent);
            }
        });





    }
}
