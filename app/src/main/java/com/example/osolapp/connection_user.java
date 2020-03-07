package com.example.osolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class connection_user extends AppCompatActivity {

    private static final int NEXT_REQUEST_CODE=0;
    public static final String IS_SHOWN = "IS_SHOWN";
    private boolean isShown = true;
    private Button button_user;
    EditText edit_user;
    EditText edit_mdp;
    String mot_de_passe;
    String utilisateur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection_user);
        button_user=findViewById(R.id.button_user);
        edit_user=(EditText)findViewById(R.id.user_user);
        edit_mdp=(EditText)findViewById(R.id.password_user);
        mot_de_passe=edit_mdp.getText().toString();
        button_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utilisateur=edit_user.getText().toString();
                String mdp="SELECT password FROM users WHERE user="+utilisateur+"";
                if(mdp==mot_de_passe) {
                    Intent intent = new Intent(connection_user.this, info_pico_user.class);
                    intent.putExtra(IS_SHOWN, isShown);
                    startActivity(intent);
                }else {
                    Toast.makeText(connection_user.this,"mot de passe incorrect",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}
