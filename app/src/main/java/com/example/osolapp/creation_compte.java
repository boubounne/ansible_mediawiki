package com.example.osolapp;

import android.database.sqlite.SQLiteDatabase;
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

public class creation_compte extends AppCompatActivity {

    public EditText Name;
    public EditText User;
    public EditText Mail;
    public EditText Password;
    public EditText Password2;
    public CheckBox Osolien;
    public Button Register;

    ProfilManager pm = new ProfilManager(this);

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
                boolean osolien = false;
                if (Osolien.isChecked())
                    osolien = true;

                profil newProfil = new profil(name, user, password, mail, osolien);
                pm.open();
                pm.addProfil(newProfil);
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
