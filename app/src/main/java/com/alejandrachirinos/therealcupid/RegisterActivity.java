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
        parent = new LinearLayout(RegisterActivity.this);
        parent.setOrientation(LinearLayout.VERTICAL);
        parent.setBackground(getResources().getDrawable(R.drawable.style_form_register));

        scrollView = new ScrollView(context);
        LinearLayout.LayoutParams scrollViewparams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        scrollView.setBackgroundColor(getResources().getColor(R.color.transparente));

        //Name
        nameTextView = new TextView(context);
        nameTextView.setText(getString(R.string.name));
        parent.addView(nameTextView);
        nameEditText = new EditText(context);
        parent.addView(nameEditText);

        //Lastname
        lastnameTextView = new TextView(context);
        lastnameTextView.setText(getString(R.string.lastname));
        parent.addView(lastnameTextView);
        lastnameEditText = new EditText(context);
        parent.addView(lastnameEditText);

        //Username
        usernameTextView = new TextView(context);
        usernameTextView.setText(getString(R.string.username));
        parent.addView(usernameTextView);
        usernameEditText = new EditText(context);
        parent.addView(usernameEditText);

        //Password
        passwordTextView = new TextView(context);
        passwordTextView.setText(getString(R.string.password));
        parent.addView(passwordTextView);
        passwordEditText = new EditText(context);
        parent.addView(passwordEditText);

        //Email
        emailTextView = new TextView(context);
        emailTextView.setText(getString(R.string.email));
        parent.addView(emailTextView);
        emailEditText = new EditText(context);
        parent.addView(emailEditText);

        //Code
        codeTextView = new TextView(context);
        codeTextView.setText(getString(R.string.code));
        parent.addView(codeTextView);
        codeEditText = new EditText(context);
        parent.addView(codeEditText);

        //University
        universityTextView = new TextView(context);
        universityTextView.setText(getString(R.string.university));
        parent.addView(universityTextView);
        universityEditText = new EditText(context);
        parent.addView(universityEditText);

        //Carrer
        carrerTextView = new TextView(context);
        carrerTextView.setText(getString(R.string.carrer));
        parent.addView(carrerTextView);
        carrerEditText = new EditText(context);
        parent.addView(carrerEditText);

        //Buttons
        buttonsLinearLayout = new LinearLayout(context);
        buttonsLinearLayout.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams buttonLayoutParam = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        buttonsLinearLayout.setBackgroundColor(getResources().getColor(R.color.fondoBotones));

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

        scrollView.addView(buttonsLinearLayout);
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
                String email = passwordEditText.getText().toString().trim();

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
