package com.alejandrachirinos.therealcupid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.alejandrachirinos.therealcupid.Repository.UserRepository;
import com.alejandrachirinos.therealcupid.model.User;
import com.alejandrachirinos.therealcupid.utils.Constants;
import com.google.gson.Gson;

public class LoginActivity extends AppCompatActivity {

    public static String LOG = LoginActivity.class.getName();
    private Button buttonLogin3;
    private EditText editTextTextPersonName;
    private EditText editTextTextPassword3;
    private CheckBox rememberMeCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.e(LOG,"onCreate");
        UserRepository userRepository = new UserRepository(LoginActivity.this);
        User userLogged = userRepository.getUserLogged();
        if (userLogged != null) {
            Intent menuIntent = new Intent(
                    LoginActivity.this, //Origen
                    MenuActivity.class); //Destino
            String userString = new Gson().toJson(userLogged);
            Log.e("user", userString);
            menuIntent.putExtra(Constants.INTENT_KEY_USER, userString);
            startActivity(menuIntent);
        } else {
            initViews();
            addEvents();
        }
    }
    private void initViews() {
        buttonLogin3 = findViewById(R.id.loginButton3);
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        editTextTextPassword3 = findViewById(R.id.editTextTextPassword3);
        rememberMeCheckBox = findViewById(R.id.checkBox);
    }
    private void  addEvents(){
        buttonLogin3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextTextPersonName.getText().toString().trim();
                String password = editTextTextPassword3.getText().toString().trim();
                if (username.equals("")){

                    editTextTextPersonName.setError(getString(R.string.error_empty));
                    return;
                }

                if (password.equals("")) {
                    editTextTextPassword3.setError(getString(R.string.error_incorrectValues));
                    return;
                }

                UserRepository userRepository = new UserRepository(LoginActivity.this);
                User userLogged = userRepository.Login(username, password);

                if (userLogged == null){
                    Toast.makeText(LoginActivity.this,getString(R.string.error_incorrectValues), Toast.LENGTH_SHORT).show();
                    return;
                }
                if (rememberMeCheckBox.isChecked() && userLogged != null) {
                    //Guardamos el objeto usuario en SharedPreferences
                    userRepository.setUserLogged(userLogged);
                }
                Intent menuIntent = new Intent(LoginActivity.this, MenuActivity.class);
                String userString = new Gson().toJson(userLogged);
                menuIntent.putExtra(Constants.INTENT_KEY_USER, userString);

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
