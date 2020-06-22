package com.alejandrachirinos.therealcupid;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

public class ProfileActivity extends AppCompatActivity {
    private AppCompatImageButton buttonCamara;
    private AppCompatImageButton buttonChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }
}
