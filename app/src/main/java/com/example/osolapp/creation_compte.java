package com.example.osolapp;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.system.Os;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class creation_compte extends AppCompatActivity {

    public EditText Name;
    public EditText User;
    public EditText Mail;
    public EditText Password;
    public EditText Password2;
    public CheckBox Osolien;
    public Button Register;
    TextView tv_1, tv_2, tv_3,tv_4;
    ProfilManager pm = new ProfilManager(this);

    public int validatePassword(String password){

        Pattern upperCase = Pattern.compile("[A-Z]");
        Pattern lowerCase = Pattern.compile("[a-z]");
        Pattern digitcase = Pattern.compile("[0-9]");
        int counter=0;
        if(!lowerCase.matcher(password).find()){
            tv_1.setTextColor(Color.RED);
        }else{
            tv_1.setTextColor(Color.GREEN);
            counter=counter+1;
        }

        if(!upperCase.matcher(password).find()){
            tv_2.setTextColor(Color.RED);
        }else{
            tv_2.setTextColor(Color.GREEN);
            counter=counter+1;
        }

        if(!digitcase.matcher(password).find()){
            tv_3.setTextColor(Color.RED);
        }else{
            tv_3.setTextColor(Color.GREEN);
            counter=counter+1;
        }

        if(password.length() <8){
            tv_4.setTextColor(Color.RED);
        }else{
            tv_4.setTextColor(Color.GREEN);
            counter=counter+1;
        }
        return counter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_compte);
        this.Name = findViewById(R.id.et_name);
        this.User = findViewById(R.id.user);
        this.Mail = findViewById(R.id.et_email);
        this.Password = findViewById(R.id.et_password);
        this.Password2 = findViewById(R.id.et_repassword);
        this.Osolien = findViewById(R.id.checkbox1);
        this.Register = findViewById(R.id.btn_register);

        this.Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = Name.getText().toString();
                String user = User.getText().toString();
                String mail = Mail.getText().toString();
                String password = Password.getText().toString();
                String password2 = Password2.getText().toString();
                if (password.equals(password2)) {
                    boolean osolien = false;
                    if (Osolien.isChecked())
                        osolien = true;

                    profil newProfil = new profil(name, user, password, mail, osolien);
                    pm.open();
                    pm.addProfil(newProfil);
                    pm.close();
                    Toast.makeText(creation_compte.this, "Compte ajouté à la BDD ;)",
                            Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(creation_compte.this, "Les 2 Passwords sont différents :(",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }




    /*public void recupProfil(){
        if (controle.getName() != null){
            this.Name.setText(controle.getName().toString());
            this.User.setText(controle.getUser().toString());
            this.Mail.setText(controle.getMail().toString());
            this.Password.setText(controle.getPassword().toString());
            this.Osolien.setChecked(false);
            if (controle.getOsolien()){
                this.Osolien.setChecked(true);
            }
            ((Button)findViewById(R.id.btn_register)).performClick();
        }
    }*/

}
