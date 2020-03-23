package com.example.osolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class DataView extends AppCompatActivity {

    Button buttonName;
    Button buttonUser;
    Button buttonEmail;
    EditText Name;
    TextView affiche;
    ProfilManager pm = new ProfilManager(this);
    ImageButton btt1;
    ImageButton btt2;
    ImageButton btt3;
    public static final String IS_SHOWN = "IS_SHOWN";
    private boolean isShown = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_view);
        buttonName=findViewById(R.id.butName);
        buttonEmail=findViewById(R.id.btEmail);
        buttonUser=findViewById(R.id.btUser);
        Name=findViewById(R.id.name);
        affiche=findViewById(R.id.textAffiche);


        buttonName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Nom=Name.getText().toString();
                pm.open();
                profil p=pm.getRechercheName(Nom);
                pm.close();
                affiche.setText(" Nom : "+p.getName()+"\n"+" User : "+p.getUser()+"\n"+" Email : "+p.getEmail());

            }
        });


        buttonUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Nom=Name.getText().toString();
                pm.open();
                profil p=pm.getRechercheUser(Nom);
                pm.close();
                affiche.setText(" Nom : "+p.getName()+"\n"+" User : "+p.getUser()+"\n"+" Email : "+p.getEmail());

            }
        });

        buttonEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Nom=Name.getText().toString();
                pm.open();
                profil p=pm.getRechercheEmail(Nom);
                pm.close();
                affiche.setText(" Nom : "+p.getName()+"\n"+" User : "+p.getUser()+"\n"+" Email : "+p.getEmail());

            }
        });



        btt1=findViewById(R.id.imageBt1);
        btt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DataView.this, "Retour au menu principal",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(DataView.this,MainActivity.class );
                intent.putExtra(IS_SHOWN, isShown);
                startActivity(intent);
            }
        });


        btt2=findViewById(R.id.imageButton5);
        btt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataView.this,connect.class );
                intent.putExtra(IS_SHOWN, isShown);
                startActivity(intent);
            }
        });

        btt3=findViewById(R.id.imageBt3);
        btt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DataView.this, "Description de OSol et Pico",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(DataView.this,description.class);
                intent.putExtra(IS_SHOWN,isShown);
                startActivity(intent);
            }
        });


    }

}
