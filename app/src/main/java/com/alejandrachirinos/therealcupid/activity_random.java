package com.alejandrachirinos.therealcupid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alejandrachirinos.therealcupid.Repository.local.OtherUsersRepository;
import com.alejandrachirinos.therealcupid.model.User;
import com.alejandrachirinos.therealcupid.utils.Constants;
import com.google.gson.Gson;

public class activity_random extends AppCompatActivity {
    public static String LOG = activity_random.class.getName();

    private User user;
    private ImageView fotoDePerfil;
    private TextView textUser;
    private TextView ageText;
    private TextView careerText;
    private Button HelloButton;
    private Button ThankUNext;
    private OtherUsersRepository otherUsersRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        otherUsersRepository = new OtherUsersRepository(getApplication());

        initViews();
        randomSearch();
        addEvents();
    }
    private void initViews() {

        textUser = findViewById(R.id.textUser);
        ageText = findViewById(R.id.textAge);
        careerText = findViewById(R.id.textCareer);
        HelloButton = findViewById(R.id.botonHello);
        ThankUNext = findViewById(R.id.ThankUnext);
        fotoDePerfil = findViewById(R.id.imageProfileRandom);
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

                Log.e(LOG, "llegaste a thank u next");
                randomSearch();
            }
        });
    }
    private void randomSearch() {
        LiveData<User> user2 = otherUsersRepository.getRandom();
        user = user2.getValue();
        Log.e(LOG, "llegaste aqui");


        if(user!=null){
            Log.e(LOG, "conseguisteEl usuario");

            textUser.setText(user.getUsername());
            ageText.setText(user.getAge()+"");
            careerText.setText(user.getCareer());
            fotoDePerfil.setImageResource(user.getImage());
        }else{
            Log.e(LOG, "no habia");

        }

    }
}
