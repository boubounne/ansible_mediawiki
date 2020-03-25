package com.example.osolapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.GridLayoutManager;


public class personne extends AppCompatActivity {


    View v;
    private RecyclerView myrecyclerView;
    private android.content.Context Context;
    ArrayList<String> personNames;
    ArrayList<Integer> personImages;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // ArrayList for person names
        super.onCreate(savedInstanceState);
        ArrayList<String> personNames = new ArrayList<>(Arrays.asList("Person 1", "Person 2", "Person 3", "Person 4", "Person 5", "Person 6"));
        ArrayList<Integer> personImages = new ArrayList<>(Arrays.asList(R.drawable.person1, R.drawable.person2, R.drawable.person3, R.drawable.person4, R.drawable.person5, R.drawable.person6));

        //setContentView(R.layout.activity_personne);

        /*
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),3, LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
        CustomAdapter adapter = new CustomAdapter(personNames,personImages);
        */


        /*
        ProfilManager pm = new ProfilManager(this);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        ArrayList<profil> maliste = new ArrayList<>();
        pm.open();
        maliste=pm.getAll();
        pm.close();
        ProfilRecyclerAdapter adapter=new ProfilRecyclerAdapter(maliste);
        */

        //recyclerView.setAdapter(adapter);


    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.activity_personne, container, false);
        myrecyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        CustomAdapter recyclerViewAdapter = new CustomAdapter(personNames,personImages);
        myrecyclerView.setLayoutManager(new GridLayoutManager(Context,3));
        myrecyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }



}
