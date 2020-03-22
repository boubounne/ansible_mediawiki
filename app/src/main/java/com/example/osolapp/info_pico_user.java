package com.example.osolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class info_pico_user extends AppCompatActivity {


    private TextView Temp;
    private TextView Batterie;

    public int new_temp(){

        int d = (int)(Math.random() * 5);

        return d;
    }
    private Handler myHandler;
    private Runnable myRunnable = new Runnable()  {
        @Override
        public void run() {
            // Code à éxécuter de façon périodique
            Temp=findViewById(R.id.textTemp);
            String Temper =Temp.getText().toString();
            Batterie=findViewById(R.id.textBat);
            String Batte =Batterie.getText().toString();

            int valeur=new_temp();

            if(valeur%2==0){
                Temp.setText("0 °C");
                Batterie.setText("Pico n'est pas en Marche");
                Batterie.setTextColor(getResources().getColor(R.color.colorJaune));
            }else {
                Temp.setText("50 °C");
                Batterie.setText("Pico est en surchauffe");
                Batterie.setTextColor(getResources().getColor(R.color.colorRed));

            }


            myHandler.postDelayed(this,5000);

        }
    };


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_pico_user);

        myHandler = new Handler();
        myHandler.postDelayed(myRunnable,5000); // on redemande toute les 5000ms
    }

    public void onPause() {
        super.onPause();
        if(myHandler != null)
            myHandler.removeCallbacks(myRunnable); // On arrete le callback
    }
}
