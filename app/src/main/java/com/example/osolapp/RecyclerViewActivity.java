package com.example.osolapp;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_pico_osol);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new ProfilRecyclerAdapter(createStudentList(50)));
    }

    private List<profil> createStudentList(final int numberOfStudents) {
        List<profil> students = new ArrayList<>();
        if (numberOfStudents <= 0) {
            return students;
        }
        for (int i = 0; i < numberOfStudents; i++) {
            profil profil = new profil("Name " + i, "LastName " + i);
            students.add(profil);
        }
        return students;
    }

}