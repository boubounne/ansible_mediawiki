package com.example.osolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class connect extends AppCompatActivity {

    private static final int NEXT_REQUEST_CODE=0;
    public static final String IS_SHOWN = "IS_SHOWN";
    private boolean isShown = true;
    Button button1;
    ImageButton btt1;
    ImageButton btt2;
    ImageButton btt3;
    SQLiteDataBaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);
        button1=findViewById(R.id.bt1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(connect.this,connection_osol.class );
                intent.putExtra(IS_SHOWN, isShown);
                startActivity(intent);
            }
        });


        Button button2=findViewById(R.id.bt2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(connect.this,connection_user.class );
                intent.putExtra(IS_SHOWN, isShown);
                startActivity(intent);
            }
        });

        Button button3=findViewById(R.id.bt3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(connect.this,creation_compte.class);
                intent.putExtra(IS_SHOWN,isShown);
                startActivity(intent);
            }
        });

        Button button4=findViewById(R.id.bt4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(connect.this,personne.class);
                intent.putExtra(IS_SHOWN,isShown);
                startActivity(intent);
            }
        });

        btt1=findViewById(R.id.imageBt1);
        btt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(connect.this, "Retour au menu principal",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(connect.this,MainActivity.class );
                intent.putExtra(IS_SHOWN, isShown);
                startActivity(intent);
            }
        });


        btt2=findViewById(R.id.imageButton5);
        btt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(connect.this,connect.class );
                intent.putExtra(IS_SHOWN, isShown);
                startActivity(intent);
            }
        });

        btt3=findViewById(R.id.imageBt3);
        btt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(connect.this, "Description de OSol et Pico",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(connect.this,description.class);
                intent.putExtra(IS_SHOWN,isShown);
                startActivity(intent);
            }
        });

    }

}
