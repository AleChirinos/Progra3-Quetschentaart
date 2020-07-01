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
import android.widget.Toast;

import com.alejandrachirinos.therealcupid.Repository.UserRepository;
import com.alejandrachirinos.therealcupid.Repository.local.OtherUsersRepository;
import com.alejandrachirinos.therealcupid.model.User;
import com.alejandrachirinos.therealcupid.utils.Constants;
import com.google.gson.Gson;

public class activity_random extends AppCompatActivity {
    public static String LOG = activity_random.class.getName();
    private User user;
    private User user1;
    private UserRepository userRepository;
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
        userRepository=new UserRepository(activity_random.this);
        user=userRepository.getUsuarioActivo();
    }
    private void addEvents() {
        HelloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean yaEnContactos = false;
                for(User u:user.getContacts()){
                    if(u.getUsername().equals(user1.getUsername())){
                        yaEnContactos=true;
                        break;
                    }
                }
                if(yaEnContactos){
                    Toast.makeText(activity_random.this,
                            getString(R.string.rejectContactFromRandom),
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    user.addContact(user1);

                    userRepository.setUsuarioActivo(user);
                    Toast.makeText(activity_random.this,
                            user1.getUsername() + getString(R.string.addContactFromRandom),
                            Toast.LENGTH_SHORT).show();
                }
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
        otherUsersRepository.getRandom().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                user1=user;
                textUser.setText(user1.getUsername());
                ageText.setText(user1.getAge()+"");
                careerText.setText(user1.getCareer());
                fotoDePerfil.setImageResource(user1.getImage());
                fotoDePerfil.setAdjustViewBounds(true);
            }
        });
        Log.e(LOG, "llegaste aqui");
    }
}
