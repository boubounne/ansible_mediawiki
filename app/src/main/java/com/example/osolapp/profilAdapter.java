package com.example.osolapp;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class profilAdapter extends ArrayAdapter<profil> {

    private final LayoutInflater layoutInflater;

    public profilAdapter(@NonNull Context context, List<profil> profil) {
        super(context, 0, profil);
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.view_profil, parent, false);
            holder = new ViewHolder();
            holder.firstName = convertView.findViewById(R.id.usser);
            holder.lastName = convertView.findViewById(R.id.passsword);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        profil profil = getItem(position);
        holder.firstName.setText(profil.getUser());
        holder.lastName.setText(profil.getPassword());

        return convertView;
    }

    static class ViewHolder {
        private TextView firstName;
        private TextView lastName;
    }
}