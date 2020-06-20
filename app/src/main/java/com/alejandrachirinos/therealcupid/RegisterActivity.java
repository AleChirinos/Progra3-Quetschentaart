package com.alejandrachirinos.therealcupid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    public static String LOG = RegisterActivity.class.getName();
    private LinearLayout parent;
    private Context context;
    private ScrollView scrollView;

    private TextView nameTextView;
    private EditText nameEditText;

    private TextView lastnameTextView;
    private EditText lastnameEditText;

    private TextView usernameTextView;
    private EditText usernameEditText;

    private TextView passwordTextView;
    private EditText passwordEditText;

    private TextView emailTextView;
    private EditText emailEditText;

    private TextView codeTextView;
    private EditText codeEditText;

    private TextView universityTextView;
    private EditText universityEditText;

    private TextView carrerTextView;
    private EditText carrerEditText;

    private TextView spaceTextView;

    private LinearLayout buttonsLinearLayout;
    private Button loginButtonRegister;
    private Button cleanButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = RegisterActivity.this;
        setContentView(render());
        Log.e(LOG, "onCreate");
        addEvents();
        //initViews();

    }
    private View render(){
        //Parent
        parent = new LinearLayout(RegisterActivity.this);
        parent.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams parentparams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        parent.setBackground(getResources().getDrawable(R.drawable.style_form_backgraund));

        //ScrollView
        scrollView = new ScrollView(context);
        LinearLayout.LayoutParams scrollViewparams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        scrollView.setBackgroundColor(getResources().getColor(R.color.transparente));

        //Formulario Layout
        LinearLayout formLinearLayout = new LinearLayout(context);
        formLinearLayout.setOrientation(LinearLayout.VERTICAL);
        ScrollView.LayoutParams formLayoutParams = new ScrollView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        formLinearLayout.setBackground(getResources().getDrawable(R.drawable.style_form_register));

        //Name
        nameTextView = new TextView(context);
        nameTextView.setText(getString(R.string.name));
        formLinearLayout.addView(nameTextView);
        nameTextView.setTextColor(getResources().getColor(R.color.black));
        nameEditText = new EditText(context);
        formLinearLayout.addView(nameEditText);
        nameEditText.setBackground(getResources().getDrawable(R.drawable.style_form_backbuttonsbottonrosa));

        spaceTextView = new TextView(context);
        spaceTextView.setText("");
        formLinearLayout.addView(spaceTextView);

        //Lastname
        lastnameTextView = new TextView(context);
        lastnameTextView.setText(getString(R.string.lastname));
        formLinearLayout.addView(lastnameTextView);
        lastnameTextView.setTextColor(getResources().getColor(R.color.black));
        lastnameEditText = new EditText(context);
        formLinearLayout.addView(lastnameEditText);
        lastnameEditText.setBackground(getResources().getDrawable(R.drawable.style_form_backbuttonsbottonazul));

        spaceTextView = new TextView(context);
        spaceTextView.setText("");
        formLinearLayout.addView(spaceTextView);

        //Username
        usernameTextView = new TextView(context);
        usernameTextView.setText(getString(R.string.username));
        formLinearLayout.addView(usernameTextView);
        usernameTextView.setTextColor(getResources().getColor(R.color.black));
        usernameEditText = new EditText(context);
        formLinearLayout.addView(usernameEditText);
        //usernameTextView.setBackground(getResources().getDrawable(R.drawable.style_form_backbuttonstoprosa));
        usernameEditText.setBackground(getResources().getDrawable(R.drawable.style_form_backbuttonsbottonrosa));

        spaceTextView = new TextView(context);
        spaceTextView.setText("");
        formLinearLayout.addView(spaceTextView);

        //Password
        passwordTextView = new TextView(context);
        passwordTextView.setText(getString(R.string.password));
        formLinearLayout.addView(passwordTextView);
        passwordTextView.setTextColor(getResources().getColor(R.color.black));
        passwordEditText = new EditText(context);
        formLinearLayout.addView(passwordEditText);
        //passwordTextView.setBackground(getResources().getDrawable(R.drawable.style_form_backbuttonstopazul));
        passwordEditText.setBackground(getResources().getDrawable(R.drawable.style_form_backbuttonsbottonazul));

        spaceTextView = new TextView(context);
        spaceTextView.setText("");
        formLinearLayout.addView(spaceTextView);

        //Email
        emailTextView = new TextView(context);
        emailTextView.setText(getString(R.string.email));
        formLinearLayout.addView(emailTextView);
        emailTextView.setTextColor(getResources().getColor(R.color.black));
        emailEditText = new EditText(context);
        formLinearLayout.addView(emailEditText);
        //emailTextView.setBackground(getResources().getDrawable(R.drawable.style_form_backbuttonstoprosa));
        emailEditText.setBackground(getResources().getDrawable(R.drawable.style_form_backbuttonsbottonrosa));

        spaceTextView = new TextView(context);
        spaceTextView.setText("");
        formLinearLayout.addView(spaceTextView);

        //Code
        codeTextView = new TextView(context);
        codeTextView.setText(getString(R.string.code));
        formLinearLayout.addView(codeTextView);
        codeTextView.setTextColor(getResources().getColor(R.color.black));
        codeEditText = new EditText(context);
        formLinearLayout.addView(codeEditText);
        //codeTextView.setBackground(getResources().getDrawable(R.drawable.style_form_backbuttonstopazul));
        codeEditText.setBackground(getResources().getDrawable(R.drawable.style_form_backbuttonsbottonazul));

        spaceTextView = new TextView(context);
        spaceTextView.setText("");
        formLinearLayout.addView(spaceTextView);

        //University
        universityTextView = new TextView(context);
        universityTextView.setText(getString(R.string.university));
        formLinearLayout.addView(universityTextView);
        universityTextView.setTextColor(getResources().getColor(R.color.black));
        universityEditText = new EditText(context);
        formLinearLayout.addView(universityEditText);
        //universityTextView.setBackground(getResources().getDrawable(R.drawable.style_form_backbuttonstoprosa));
        universityEditText.setBackground(getResources().getDrawable(R.drawable.style_form_backbuttonsbottonrosa));

        spaceTextView = new TextView(context);
        spaceTextView.setText("");
        formLinearLayout.addView(spaceTextView);

        //Carrer
        carrerTextView = new TextView(context);
        carrerTextView.setText(getString(R.string.carrer));
        formLinearLayout.addView(carrerTextView);
        carrerTextView.setTextColor(getResources().getColor(R.color.black));
        carrerEditText = new EditText(context);
        formLinearLayout.addView(carrerEditText);
        //carrerTextView.setBackground(getResources().getDrawable(R.drawable.style_form_backbuttonstopazul));
        carrerEditText.setBackground(getResources().getDrawable(R.drawable.style_form_backbuttonsbottonazul));

        spaceTextView = new TextView(context);
        spaceTextView.setText("");
        formLinearLayout.addView(spaceTextView);

        //Buttons
        buttonsLinearLayout = new LinearLayout(context);
        buttonsLinearLayout.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams buttonLayoutParam = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        buttonsLinearLayout.setBackground(getResources().getDrawable(R.drawable.style_form_backbuttonstoprosa));

        LinearLayout.LayoutParams buttonsLayoutParams = new LinearLayout.LayoutParams(
                0,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                50);

        // Button Clean
        cleanButton = new Button(context);
        cleanButton.setText(getString(R.string.clean));
        cleanButton.setLayoutParams(buttonsLayoutParams);
        buttonsLinearLayout.addView(cleanButton);


        // Button Login
        loginButtonRegister = new Button(context);
        loginButtonRegister.setText(getString(R.string.login));
        loginButtonRegister.setLayoutParams(buttonsLayoutParams);
        buttonsLinearLayout.addView(loginButtonRegister);


        formLinearLayout.addView(buttonsLinearLayout);
        scrollView.addView(formLinearLayout);
        parent.addView(scrollView);
        return parent;
    }

    private void addEvents(){
        loginButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString().trim();
                String lastname = lastnameEditText.getText().toString().trim();
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String code = codeEditText.getText().toString().trim();
                String university = universityEditText.getText().toString().trim();
                String carrer = carrerEditText.getText().toString().trim();

                if (name.isEmpty()) {
                    Toast.makeText(context,
                            getString(R.string.error_empty_variable, "name"),
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if (lastname.isEmpty()) {
                    Toast.makeText(context,
                            getString(R.string.error_empty_variable, "lastname"),
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if (username.isEmpty()) {
                    Toast.makeText(context,
                            getString(R.string.error_empty_variable, "username"),
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.isEmpty()) {
                    Toast.makeText(context,
                            getString(R.string.error_empty_variable, "password"),
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if (email.isEmpty()) {
                    Toast.makeText(context,
                            getString(R.string.error_empty_variable, "email"),
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if (code.isEmpty()) {
                    Toast.makeText(context,
                            getString(R.string.error_empty_variable, "UniversityCode"),
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                if (university.isEmpty()) {
                    Toast.makeText(context,
                            getString(R.string.error_empty_variable, "university"),
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if (carrer.isEmpty()) {
                    Toast.makeText(context,
                            getString(R.string.error_empty_variable, "carrer"),
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });
        cleanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameEditText.setText("");
                lastnameEditText.setText("");
                usernameEditText.setText("");
                passwordEditText.setText("");
                emailEditText.setText("");
                codeEditText.setText("");
                universityEditText.setText("");
                carrerEditText.setText("");
            }
        });
    }
}
