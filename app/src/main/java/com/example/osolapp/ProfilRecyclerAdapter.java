package com.example.osolapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class ProfilRecyclerAdapter extends RecyclerView.Adapter<profilViewHolder> {

    private final ArrayList<profil> profilList;

    ProfilRecyclerAdapter(@NonNull ArrayList<profil> studentList) {
        this.profilList = studentList;
    }

    @NonNull
    @Override
    public profilViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_profil, viewGroup, false);
        return new profilViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull profilViewHolder studentViewHolder, int position) {
        studentViewHolder.bind(profilList.get(position));
    }

    @Override
    public int getItemCount() {
        return profilList.size();
    }
}
