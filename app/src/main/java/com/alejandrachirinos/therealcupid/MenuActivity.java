package com.alejandrachirinos.therealcupid;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import com.alejandrachirinos.therealcupid.model.User;
import com.alejandrachirinos.therealcupid.utils.Constants;
import com.google.gson.Gson;

public class MenuActivity extends AppCompatActivity {
    public static String LOG = LoginActivity.class.getName();
    private AppCompatImageButton buttonContact;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Log.e(LOG, "onCreate");
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
        buttonContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contactsIntent = new Intent(MenuActivity.this, ContactsActivity.class);
                String userString = new Gson().toJson(user);
                contactsIntent.putExtra(Constants.INTENT_KEY_USER, userString);
                startActivity(contactsIntent);
            }
        });
    }

    private void initViews() {
        buttonContact = findViewById(R.id.contactbutton);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(LOG, "onStart");
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
