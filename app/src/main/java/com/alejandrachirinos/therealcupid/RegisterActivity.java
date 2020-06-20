package com.alejandrachirinos.therealcupid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

    private TextView confirmPasswordTextView;
    private EditText confirmPasswordEditText;

    private TextView emailTextView;
    private EditText emailEditText;

    private TextView codeTextView;
    private EditText codeEditText;

    private TextView universityTextView;
    private EditText universityEditText;

    private TextView carrerTextView;
    private EditText carrerEditText;

    private TextView ageTextView;
    private EditText ageEditText;

    private TextView spaceTextView;

    private TextView genderTextview;
    private TextView formgender;
    private RadioGroup genderRadioGroup;

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

        //Image
        ImageView registerImage = new ImageView(context);
        registerImage.setImageResource(R.drawable.registres);
        LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(
              ViewGroup.LayoutParams.MATCH_PARENT,
              ViewGroup.LayoutParams.MATCH_PARENT);
        formLinearLayout.addView(registerImage);


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
        passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        formLinearLayout.addView(passwordEditText);
        passwordEditText.setBackground(getResources().getDrawable(R.drawable.style_form_backbuttonsbottonazul));

        spaceTextView = new TextView(context);
        spaceTextView.setText("");
        formLinearLayout.addView(spaceTextView);

        //Confirm Password
        confirmPasswordTextView= new TextView(context);
        confirmPasswordTextView.setText(getString(R.string.confirmpass));
        formLinearLayout.addView(confirmPasswordTextView);
        confirmPasswordTextView.setTextColor(getResources().getColor(R.color.black));
        confirmPasswordEditText = new EditText(context);
        confirmPasswordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        formLinearLayout.addView(confirmPasswordEditText);
        confirmPasswordEditText.setBackground(getResources().getDrawable(R.drawable.style_form_backbuttonsbottonrosa));

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
        emailEditText.setBackground(getResources().getDrawable(R.drawable.style_form_backbuttonsbottonazul));

        spaceTextView = new TextView(context);
        spaceTextView.setText("");
        formLinearLayout.addView(spaceTextView);

        //Code
        codeTextView = new TextView(context);
        codeTextView.setText(getString(R.string.code));
        formLinearLayout.addView(codeTextView);
        codeTextView.setTextColor(getResources().getColor(R.color.black));
        codeEditText = new EditText(context);
        codeEditText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED);
        formLinearLayout.addView(codeEditText);
        codeEditText.setBackground(getResources().getDrawable(R.drawable.style_form_backbuttonsbottonrosa));

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
        universityEditText.setBackground(getResources().getDrawable(R.drawable.style_form_backbuttonsbottonazul));

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
        carrerEditText.setBackground(getResources().getDrawable(R.drawable.style_form_backbuttonsbottonrosa));

        spaceTextView = new TextView(context);
        spaceTextView.setText("");
        formLinearLayout.addView(spaceTextView);

        //Age
        ageTextView = new TextView(context);
        ageTextView.setText(getString(R.string.age));
        formLinearLayout.addView(ageTextView);
        ageTextView.setTextColor(getResources().getColor(R.color.black));
        ageEditText = new EditText(context);
        ageEditText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED);
        formLinearLayout.addView(ageEditText);
        ageEditText.setBackground(getResources().getDrawable(R.drawable.style_form_backbuttonsbottonazul));

        spaceTextView = new TextView(context);
        spaceTextView.setText("");
        formLinearLayout.addView(spaceTextView);

        //Gender
        formgender = new TextView(context);
        formgender.setText(getString(R.string.gender));
        formLinearLayout.addView(formgender);
        formgender.setTextColor(getResources().getColor(R.color.black));

        genderTextview = new TextView(context);
        genderTextview.setText("Gender");
        genderRadioGroup = new RadioGroup(context);
        String[] genders = new String[]{"Male", "Female", "Not specified", "Other"};
        for (int i = 0; i < genders.length; i++) {
            RadioButton option = new RadioButton(context);
            option.setId(i);
            option.setText(genders[i]);
            genderRadioGroup.addView(option);
            genderRadioGroup.setBackground(getResources().getDrawable(R.drawable.style_form_backbuttonsbottonrosa));
        }
        genderRadioGroup.check(0);
        formLinearLayout.addView(genderRadioGroup);

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
                String confirmPassword = passwordEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String code = codeEditText.getText().toString().trim();
                String university = universityEditText.getText().toString().trim();
                String carrer = carrerEditText.getText().toString().trim();
                String age = carrerEditText.getText().toString().trim();

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
                if(username.contains(" ")){
                    Toast.makeText(context,
                            getString(R.string.invalid, "username"),
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.isEmpty()) {
                    Toast.makeText(context,
                            getString(R.string.error_empty_variable, "password"),
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if (confirmPassword.isEmpty()) {
                    Toast.makeText(context,
                            getString(R.string.error_empty_variable, "password"),
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!password.equals(confirmPassword)){
                    Toast.makeText(context,
                            getString(R.string.wrongPassword, "password"),
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if (email.isEmpty()) {
                    Toast.makeText(context,
                            getString(R.string.error_empty_variable, "email"),
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    Toast.makeText(context,
                            getString(R.string.invalid, "email"),
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if (code.isEmpty()) {
                    Toast.makeText(context,
                            getString(R.string.error_empty_variable, "UniversityCode"),
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!(code.length() == 5 && !code.contains(" "))){
                    Toast.makeText(context,
                            getString(R.string.invalid, "code"),
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                if (university.isEmpty()) {
                    Toast.makeText(context,
                            getString(R.string.error_empty_variable, "university"),
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!university.contains("UPB")) {
                    Toast.makeText(context,
                            getString(R.string.invalid, "university"),
                            Toast.LENGTH_SHORT).show();
                    return;
                }


                if (carrer.isEmpty()) {
                    Toast.makeText(context,
                            getString(R.string.error_empty_variable, "carrer"),
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                if (age.isEmpty()) {
                    Toast.makeText(context,
                            getString(R.string.error_empty_variable, "age"),
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
