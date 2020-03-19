package com.example.osolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class description extends AppCompatActivity {

    ImageButton btt1;
    ImageButton btt2;
    ImageButton btt3;
    public static final String IS_SHOWN = "IS_SHOWN";
    private boolean isShown = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        btt1=findViewById(R.id.imageBt1);
        btt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(description.this, "Retour au menu principal",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(description.this,MainActivity.class );
                intent.putExtra(IS_SHOWN, isShown);
                startActivity(intent);
            }
        });


        btt2=findViewById(R.id.imageButton5);
        btt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(description.this,connect.class );
                intent.putExtra(IS_SHOWN, isShown);
                startActivity(intent);
            }
        });

        btt3=findViewById(R.id.imageBt3);
        btt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(description.this, "Description de OSol et Pico",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(description.this,description.class);
                intent.putExtra(IS_SHOWN,isShown);
                startActivity(intent);
            }
        });


    }
}
