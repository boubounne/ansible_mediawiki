package com.example.osolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DataView extends AppCompatActivity {

    Button buttonName;
    Button buttonUser;
    Button buttonEmail;
    EditText Name;
    ProfilManager pm = new ProfilManager(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_view);
        buttonName=findViewById(R.id.butName);
        buttonEmail=findViewById(R.id.btEmail);
        buttonUser=findViewById(R.id.btUser);
        Name=findViewById(R.id.name);

        buttonName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Nom=Name.getText().toString();
                pm.open();
                profil p=pm.getRechercheName(Nom);
                pm.close();
                Toast.makeText(DataView.this, "nom : "+p.getName()+" user : "+p.getUser()+" email : "+p.getEmail(),
                        Toast.LENGTH_LONG).show();

            }
        });


        buttonUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Nom=Name.getText().toString();
                pm.open();
                profil p=pm.getRechercheName(Nom);
                pm.close();
                Toast.makeText(DataView.this, "nom : "+p.getName()+" user : "+p.getUser()+" email : "+p.getEmail(),
                        Toast.LENGTH_LONG).show();

            }
        });

        buttonEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Nom=Name.getText().toString();
                pm.open();
                profil p=pm.getRechercheName(Nom);
                pm.close();
                Toast.makeText(DataView.this, "nom : "+p.getName()+" user : "+p.getUser()+" email : "+p.getEmail(),
                        Toast.LENGTH_LONG).show();

            }
        });


    }

}
