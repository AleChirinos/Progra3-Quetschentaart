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
    private AppCompatImageButton buttonProfile;
    private AppCompatImageButton buttonRandomSearch;
    private AppCompatImageButton buttonChats;
    private AppCompatImageButton buttonContactUs;
    private AppCompatImageButton buttonSettings;


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

        buttonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Intent profilIntent = new Intent(MenuActivity.this, ProfileActivity.class);
                startActivity(profilIntent);
                */
                Toast.makeText(MenuActivity.this, //Origen
                        "Pronto podras ver tu perfil aqui", //Mensaje
                        Toast.LENGTH_SHORT) //Duracion
                        .show();            }
        });
        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuActivity.this, //Origen
                        "Pronto podras ver las configuraciones aqui", //Mensaje
                        Toast.LENGTH_SHORT) //Duracion
                        .show();            }
        });
        buttonRandomSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MenuActivity.this, //Origen
                        "Pronto podras hacer tu busqueda aqui", //Mensaje
                        Toast.LENGTH_SHORT) //Duracion
                        .show();            }
        });
        buttonContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuActivity.this, //Origen
                        "Pronto podras contactarnos aqui", //Mensaje
                        Toast.LENGTH_SHORT) //Duracion
                        .show();            }
        });
        buttonChats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuActivity.this, //Origen
                        "Pronto podras ver tus chats aqui", //Mensaje
                        Toast.LENGTH_SHORT) //Duracion
                        .show();            }
        });
}

    private void initViews() {
        buttonContact = findViewById(R.id.contactbutton);
        buttonProfile = findViewById(R.id.profile);
        buttonChats = findViewById(R.id.chats);
        buttonContactUs = findViewById(R.id.contact_us);
        buttonRandomSearch = findViewById(R.id.random_search);
        buttonSettings = findViewById(R.id.settings);

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
