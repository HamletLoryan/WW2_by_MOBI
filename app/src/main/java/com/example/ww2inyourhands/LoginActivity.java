package com.example.ww2inyourhands;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    public static boolean loggedIn;

    EditText emailEditText, passwordEditText;
    Button logInButton, backButton;
    ProgressBar progressBar;
    TextView createAccountBtnTextView;

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.email_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        logInButton = findViewById(R.id.log_in_button);
        backButton = findViewById(R.id.back_btn);
        createAccountBtnTextView = findViewById(R.id.login_btn);
        firebaseAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progress_bar);
        backButton.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, StartMenu.class)));

        loggedIn = false;


        createAccountBtnTextView.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, CreateAccountActivity.class)));

        logInButton.setOnClickListener(v -> {
            String email, password;
            email = String.valueOf(emailEditText.getText());
            password = String.valueOf(passwordEditText.getText());

            if (TextUtils.isEmpty(email)) {
                emailEditText.setError("Please enter your email.");
                return;
            }
            if (TextUtils.isEmpty(password)) {
                passwordEditText.setError("Please enter your password.");
                return;
            }

            logInButton.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);

            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    if (Objects.requireNonNull(firebaseAuth.getCurrentUser()).isEmailVerified()) {
                        SharedPreferences sp = getSharedPreferences("Login", MODE_PRIVATE);
                        SharedPreferences.Editor Ed = sp.edit();
                        Ed.putBoolean("IsLoggedIn", true);
                        Ed.putString("Email", email);
                        Ed.putString("Password", password);
                        Ed.apply();

                        loggedIn = true;
                        Toast.makeText(LoginActivity.this, R.string.logged_in_successfully, Toast.LENGTH_SHORT).show();
                    } else {
                        logInButton.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(LoginActivity.this, R.string.verify_your_email, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    logInButton.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(LoginActivity.this, Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });
    }

    @Override
    public void onBackPressed() {
    }


}