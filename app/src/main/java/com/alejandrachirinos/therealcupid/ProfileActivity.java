package com.alejandrachirinos.therealcupid;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View.OnClickListener;


public class ProfileActivity extends AppCompatActivity {
    public static String LOG = LoginActivity.class.getName();

    private AppCompatImageButton buttonCamara;
    private AppCompatImageButton buttonChat;
    private ImageView img;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initViews();
        addEvents();
    }

    private void initViews() {
        buttonCamara = findViewById(R.id.camara);
        img = findViewById(R.id.imageProfile);
    }


    private void addEvents() {
        buttonCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }



}
