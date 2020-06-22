package com.alejandrachirinos.therealcupid;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatSeekBar;

import com.alejandrachirinos.therealcupid.Repository.UserRepository;
import com.alejandrachirinos.therealcupid.model.User;
import com.alejandrachirinos.therealcupid.utils.Constants;
import com.google.gson.Gson;

public class WRUInterestedActivity extends AppCompatActivity {

    public static String LOG = LoginActivity.class.getName();
    private AppCompatSeekBar demoseekBar;
    private Button donebutton;
    private User user;
    private AppCompatImageButton buttonMujer;
    private AppCompatImageButton buttonAmbos;
    private AppCompatImageButton buttonHombre;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interested);
        receiveValues();
        initViews();
        addEvents();

    }
    private void receiveValues() {
        //canal
        Intent intent = getIntent();

        //"objUser"
        if (intent.hasExtra(Constants.INTENT_KEY_USER)) {

            //ensaje con la clave: "objUser"
            String userObj = intent.getStringExtra(Constants.INTENT_KEY_USER);

            //Convertir el String a un Objeto
            user = new Gson().fromJson(userObj, User.class);

        }
    }

    private void addEvents() {
        demoseekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                Log.e(LOG,"onProgressChanged"+ progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.e(LOG,"onStopTrackingTouch"+ seekBar.getProgress());

            }
        });

        buttonMujer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mujerIntent = new Intent(WRUInterestedActivity.this, LoginActivity.class);
                UserRepository.getInstance().register(user);

                user.setInterest("mujeres");

                UserRepository.getInstance().register(user);
                startActivity(mujerIntent);
            }
        });
        buttonAmbos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ambosIntent = new Intent(WRUInterestedActivity.this, LoginActivity.class);
                user.setInterest("ambos");
                UserRepository.getInstance().register(user);
                startActivity(ambosIntent);
            }
        });
        buttonHombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hombreIntent = new Intent(WRUInterestedActivity.this, LoginActivity.class);
                user.setInterest("hombres");
                UserRepository.getInstance().register(user);

                startActivity(hombreIntent);
            }
        });
    }

    private void initViews() {
        demoseekBar=findViewById(R.id.demoseekBar);
        buttonMujer = findViewById(R.id.mujer);
        buttonAmbos = findViewById(R.id.ambos);
        buttonHombre = findViewById(R.id.hombre);
    }
}
