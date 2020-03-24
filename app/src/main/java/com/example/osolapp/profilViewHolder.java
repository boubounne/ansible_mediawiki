package com.example.osolapp;


import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class profilViewHolder extends RecyclerView.ViewHolder{

    private TextView User;
    private TextView Name;
    private TextView Email;

    public profilViewHolder(@NonNull View itemView) {
        super(itemView);
        User = itemView.findViewById(R.id.usser);
        Name = itemView.findViewById(R.id.namme);
        Email = itemView.findViewById(R.id.emmail);
    }

    public void bind(profil profil) {
        User.setText(profil.getUser());
        Name.setText(profil.getName());
        Email.setText(profil.getEmail());
    }
}
