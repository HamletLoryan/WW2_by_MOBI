package com.example.ww2inyourhands;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CreateAccountActivity extends AppCompatActivity {

    EditText emailEditText, passwordEditText, confirmPasswordEditText;
    Button submitButton;
    ProgressBar progressBar;
    TextView loginBtnTextView;

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        emailEditText = findViewById(R.id.email_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        confirmPasswordEditText = findViewById(R.id.confirm_password_edit_text);
        submitButton = findViewById(R.id.create_account_button);
        progressBar = findViewById(R.id.progressBar);
        loginBtnTextView = findViewById(R.id.login_btn);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        submitButton.setOnClickListener(v -> createAccount());
        loginBtnTextView.setOnClickListener(v -> finish());

    }

    void createAccount() {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String confirmPassword = confirmPasswordEditText.getText().toString();

        boolean isValidated = validateData(email, password, confirmPassword);
        if (!isValidated) {
            return;
        }

        createAccountInFirebase(email, password);
    }

    private void createAccountInFirebase(String email, String password) {

        changeInProgress(true);

        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    changeInProgress(false);
                    startActivity(new Intent(CreateAccountActivity.this, GameStartActivity.class));
                    Toast.makeText(CreateAccountActivity.this, "Created successfully, please check your email.", Toast.LENGTH_SHORT).show();
                }else{
                    changeInProgress(false);
                    Toast.makeText(CreateAccountActivity.this, "Account creation denied."+ task.getException() +" Try again later.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    void changeInProgress(boolean inProgress) {
        if (inProgress) {
            progressBar.setVisibility(View.VISIBLE);
            submitButton.setVisibility(View.GONE);
        } else {
            progressBar.setVisibility(View.GONE);
            submitButton.setVisibility(View.VISIBLE);
        }

    }

    boolean validateData(String email, String password, String confirmPassword) {

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.setError("Email is invalid");
            return false;
        }


        if (!is_Valid_Password(password)) {
            passwordEditText.setError("Password is invalid");
            return false;
        }
        if (!password.equals(confirmPassword)) {
            confirmPasswordEditText.setError("Passwords did not match");
            return false;
        } else {
            return true;
        }
    }

    public static boolean is_Valid_Password(String password) {

        if (password.length() < 8) return false;

        int charCount = 0;
        int numCount = 0;
        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (isNumeric(ch)) numCount++;
            else if (isCapitalLetter(ch)) charCount++;
        }


        return (charCount >= 1 && numCount >= 1);
    }

    private static boolean isNumeric(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static boolean isCapitalLetter(char ch) {
        return (ch >= 'A' && ch <= 'Z');
    }
}