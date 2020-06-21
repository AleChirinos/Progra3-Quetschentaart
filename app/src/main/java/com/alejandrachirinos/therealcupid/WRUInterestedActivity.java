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
import androidx.appcompat.widget.AppCompatSeekBar;

import com.alejandrachirinos.therealcupid.Repository.UserRepository;
import com.alejandrachirinos.therealcupid.model.User;
import com.alejandrachirinos.therealcupid.utils.Constants;
import com.google.gson.Gson;

public class WRUInterestedActivity extends AppCompatActivity {

    public static String LOG = LoginActivity.class.getName();
    private AppCompatSeekBar demoseekBar;

    private Button donebutton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interested);
        initViews();
        addEvents();
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

        donebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent doneIntent = new Intent(WRUInterestedActivity.this, LoginActivity.class);
                startActivity(doneIntent);
            }
        });
    }

    private void initViews() {
        demoseekBar=findViewById(R.id.demoseekBar);
        donebutton = findViewById(R.id.button);
    }
}
