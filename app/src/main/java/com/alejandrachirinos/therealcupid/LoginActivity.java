package com.alejandrachirinos.therealcupid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alejandrachirinos.therealcupid.Repository.MenuActivity;

public class LoginActivity extends AppCompatActivity {

    public static String LOG = LoginActivity.class.getName();
    private Button buttonLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.e(LOG,"onCreate");
        initViews();
        addEvents();

    }
    private void initViews() {
        buttonLogin = findViewById(R.id.loginButton);

    }
    private void  addEvents(){
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuIntent = new Intent(LoginActivity.this, MenuActivity.class);
                startActivity(menuIntent);
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e(LOG,"onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(LOG,"onDestroy");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(LOG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(LOG,"onPause");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(LOG,"onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(LOG,"onStop");
    }
}