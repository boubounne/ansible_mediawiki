package com.example.osolapp;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class info_pico_osol extends AppCompatActivity {

    ProfilManager pm = new ProfilManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_pico_osol);
        List<profil> ma_liste = new ArrayList<>();
        ma_liste=createProfilList();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        profilAdapter adapter=new profilAdapter(ma_liste);
        recyclerView.setAdapter(adapter);
    }

    private List<profil> createProfilList() {
        List<profil> maliste = new ArrayList<>();
        pm.open();
        maliste=pm.getAll();
        pm.close();

        return maliste;
    }

}