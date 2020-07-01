package com.alejandrachirinos.therealcupid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alejandrachirinos.therealcupid.Repository.local.OtherUsersRepository;

public class InicioActivity extends AppCompatActivity {
    public static String LOG = LoginActivity.class.getName();
    private Button buttonLogin;
    private Button buttonRegister;
    private OtherUsersRepository otherUsersRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Log.e(LOG, "onCreate");
        initViews();
        addEvents();
        otherUsersRepository=new OtherUsersRepository(getApplication());
    }
    private void initViews(){
        buttonLogin = findViewById(R.id.loginButton);
        buttonRegister = findViewById(R.id.registerButton);
    }

    private void addEvents(){
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(InicioActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(InicioActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.e(LOG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(LOG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(LOG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(LOG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(LOG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(LOG, "onDestroy");
    }
}
