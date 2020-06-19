package com.alejandrachirinos.therealcupid;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    public static String LOG = LoginActivity.class.getName();
    private Button buttonContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Log.e(LOG, "onCreate");
        initViews();
        addEvents();
    }

    private void addEvents() {
        buttonContact = findViewById(R.id.contactbutton);
    }

    private void initViews() {
        buttonContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuIntent = new Intent(MenuActivity.this, ContactsActivity.class);
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
