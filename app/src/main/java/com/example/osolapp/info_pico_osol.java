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
        ArrayList<profil> ma_liste = new ArrayList<>();
        ma_liste=createProfilList();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        ProfilRecyclerAdapter adapter = new ProfilRecyclerAdapter(ma_liste);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<profil> createProfilList() {
        ArrayList<profil> maliste = new ArrayList<>();
        pm.open();
        maliste=pm.getAll();
        pm.close();

        return maliste;
    }

}