package com.example.osolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class connection_osol extends AppCompatActivity {


    private static final int NEXT_REQUEST_CODE=0;
    public static final String IS_SHOWN = "IS_SHOWN";
    private boolean isShown = true;
    Button buttonosol;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection_osol);
        buttonosol=findViewById(R.id.button_osol);
        buttonosol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(connection_osol.this,info_pico_osol.class );
                intent.putExtra(IS_SHOWN, isShown);
                startActivity(intent);
            }
        });

}
}
