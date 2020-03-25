package com.example.osolapp;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.GridLayoutManager;

public class personneViewHolder extends RecyclerView.ViewHolder{

    private TextView Name;
    private ImageView Image;

    public personneViewHolder(@NonNull View itemView) {
        super(itemView);
        Image = itemView.findViewById(R.id.imagee);
        Name = itemView.findViewById(R.id.namme);
        String namme=Name.getText().toString();

    }

    public void bind(profil profil) {
        Name.setText(profil.getName());
    }
}
