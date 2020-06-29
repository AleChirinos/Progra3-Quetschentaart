package com.alejandrachirinos.therealcupid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.alejandrachirinos.therealcupid.Repository.UserRepository;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class ContactUsActivity extends AppCompatActivity {
    TextView logOff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        initViews();
        addEvents();
    }
    public void email1(View view){
        Intent intent=null, chooser=null;
        intent =new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        String[] to={"fabian.machicao@gmail.com"};
        intent.putExtra(Intent.EXTRA_EMAIL,to);
        intent.putExtra(Intent.EXTRA_SUBJECT,"My problem");
        intent.putExtra(Intent.EXTRA_TEXT,"Hola! Quisiera hacer una pregunta, ");
        intent.setType("message/rfc822");
        chooser=Intent.createChooser(intent,"send email");
        startActivity(chooser);
    }
    public void email2(View view){
        Intent intent=null, chooser=null;
        intent =new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        String[] to={"alejandra.chirinos2702@gmail.com"};
        intent.putExtra(Intent.EXTRA_EMAIL,to);
        intent.putExtra(Intent.EXTRA_SUBJECT,"My problem");
        intent.putExtra(Intent.EXTRA_TEXT,"Hola! Quisiera hacer una pregunta, ");
        intent.setType("message/rfc822");
        chooser=Intent.createChooser(intent,"send email");
        startActivity(chooser);
    }
    public void email3(View view){
        Intent intent=null, chooser=null;
        intent =new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        String[] to={"erickmallea1234@gmail.com"};
        intent.putExtra(Intent.EXTRA_EMAIL,to);
        intent.putExtra(Intent.EXTRA_SUBJECT,"My problem");
        intent.putExtra(Intent.EXTRA_TEXT,"Hola! Quisiera hacer una pregunta, ");
        intent.setType("message/rfc822");
        chooser=Intent.createChooser(intent,"send email");
        startActivity(chooser);
    }
    public void email4(View view){
        Intent intent=null, chooser=null;
        intent =new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        String[] to={"denissebaldiviesopacheco@gmail.com"};
        intent.putExtra(Intent.EXTRA_EMAIL,to);
        intent.putExtra(Intent.EXTRA_SUBJECT,"My problem");
        intent.putExtra(Intent.EXTRA_TEXT,"Hola! Quisiera hacer una pregunta, ");
        intent.setType("message/rfc822");
        chooser=Intent.createChooser(intent,"send email");
        startActivity(chooser);
    }
    private void initViews() {
        logOff = findViewById(R.id.logOffTextView);
    }
    private void  addEvents() {
        logOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserRepository userRepository = new UserRepository(ContactUsActivity.this);
                userRepository.deleteUserLogged();

            }
        });    }
}
