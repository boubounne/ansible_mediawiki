package com.example.osolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DataView extends AppCompatActivity {

    Button button;
    EditText Name;
    ProfilManager pm = new ProfilManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_view);
        button=findViewById(R.id.boutton);
        Name=findViewById(R.id.name);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Nom=Name.getText().toString();
                pm.open();
                profil p=pm.getProfil(Nom);
                pm.close();
                // On doit tout récupérer pas seulement 1 valeur.
                // On doit faire la requeête dans profilManger ( getRecherce)
                // Et ensuite afficher en liste. For ça marchera mais bon assez tendu

            }
        });


    }

}
