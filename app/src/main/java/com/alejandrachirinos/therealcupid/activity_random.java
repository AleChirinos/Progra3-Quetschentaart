package com.alejandrachirinos.therealcupid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alejandrachirinos.therealcupid.model.User;
import com.alejandrachirinos.therealcupid.utils.Constants;
import com.google.gson.Gson;

public class activity_random extends AppCompatActivity {
    private User user;
    private TextView textUser;
    private TextView ageText;
    private TextView careerText;
    private Button HelloButton;
    private Button ThankUNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        initViews();
        addEvents();
    }
    private void initViews() {

        textUser = findViewById(R.id.textUser);
        ageText = findViewById(R.id.textAge);
        careerText = findViewById(R.id.textCareer);
        HelloButton = findViewById(R.id.botonHello);
        ThankUNext = findViewById(R.id.ThankUNext);
    }
    private void addEvents() {
        HelloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ThankUNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
