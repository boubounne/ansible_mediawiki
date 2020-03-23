package com.example.osolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    private static final int NEXT_REQUEST_CODE=0;
    public static final String IS_SHOWN = "IS_SHOWN";
    private boolean isShown = true;
    ImageButton button1;
    ImageButton button2;
    ImageButton button3;
    SQLiteDataBaseHelper db;
    Chronometer simpleChronometer;
    long timer;
    Button start, stop, restart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1=findViewById(R.id.imageBt1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Retour au menu principal",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,MainActivity.class );
                intent.putExtra(IS_SHOWN, isShown);
                startActivity(intent);
            }
        });


        button2=findViewById(R.id.imageButton5);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,connect.class );
                intent.putExtra(IS_SHOWN, isShown);
                startActivity(intent);
            }
        });

        button3=findViewById(R.id.imageBt3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Description de OSol et Pico",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,description.class);
                intent.putExtra(IS_SHOWN,isShown);
                startActivity(intent);
            }
        });





        ProfilManager pm = new ProfilManager(this);
        pm.open();
        pm.addProfil(new profil("alexandre", "alex", "azerty", "alex@devinci", true));
        pm.addProfil(new profil("corentin", "cjpm", "aaa", "cjpm@devinci", false));
    }




}