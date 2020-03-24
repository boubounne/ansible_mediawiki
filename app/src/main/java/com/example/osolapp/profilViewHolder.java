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
        String usser=User.getText().toString();
        Name = itemView.findViewById(R.id.namme);
        String namme=Name.getText().toString();
        Email = itemView.findViewById(R.id.emmail);
        String emmail=Email.getText().toString();


    }

    public void bind(profil profil) {

        //User=itemView.findViewById(R.id.usser);
        //String usser =User.getText().toString();
        User.setText(profil.getUser());
        Name.setText(profil.getName());
        Email.setText(profil.getEmail());
    }
}
