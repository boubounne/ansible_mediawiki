package com.example.osolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private static final int NEXT_REQUEST_CODE=0;
    public static final String IS_SHOWN = "IS_SHOWN";
    private boolean isShown = true;
    private Button button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=findViewById(R.id.bt1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,connection_osol.class );
                intent.putExtra(IS_SHOWN, isShown);
                startActivity(intent);
            }
        });


        Button button2=findViewById(R.id.bt2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,connection_user.class );
                intent.putExtra(IS_SHOWN, isShown);
                startActivity(intent);
            }
        });
    }



}
