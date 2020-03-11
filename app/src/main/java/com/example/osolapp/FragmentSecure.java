package com.example.osolapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FragmentSecure extends Fragment {

    private EditText txtLogin;
    private EditText txtPassword;
    private TextView tv_1;
    private TextView tv_2;
    private TextView tv_3;
    private TextView tv_4;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_fragment_secure, container,true);

        txtLogin=(EditText) rootView.findViewById(R.id.user);
        txtPassword=(EditText) rootView.findViewById(R.id.password);
        tv_1=(TextView) rootView.findViewById(R.id.tv_1);
        tv_2=(TextView) rootView.findViewById(R.id.tv_2);
        tv_3=(TextView) rootView.findViewById(R.id.tv_3);
        tv_4=(TextView) rootView.findViewById(R.id.tv_4);


        return rootView;
    }


}
