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
                if (task.isSuccessful()) {
                    changeInProgress(false);
                    startActivity(new Intent(CreateAccountActivity.this, StartMenu.class));
                    Toast.makeText(CreateAccountActivity.this, "Created successfully, please check your email.", Toast.LENGTH_SHORT).show();
                } else {
                    changeInProgress(false);
                    Toast.makeText(CreateAccountActivity.this, "Account creation denied." + task.getException() + " Try again later.", Toast.LENGTH_SHORT).show();
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

        if (!isThePasswordLengthValid(password)) {
            passwordEditText.setError("The password must contain at least eight characters.");
            return false;
        }
        if (!isThePasswordContainingDigits(password)) {
            passwordEditText.setError("The password must contain at least one digit.");
            return false;
        }
        if (!isThePasswordContainingCapitals(password)) {
            passwordEditText.setError("The password must contain at least one Uppercase character.");
            return false;
        }
        if (!isThePasswordContainingLowercaseChars(password)) {
            passwordEditText.setError("The password must contain at least one lowercase character.");
            return false;
        }
        if (!isThePasswordContainingSigns(password)) {
            passwordEditText.setError("The password must contain at least one sign character.");
            return false;
        }

        if (!password.equals(confirmPassword)) {
            confirmPasswordEditText.setError("Passwords did not match");
            return false;
        } else {
            return true;
        }
    }

    public static boolean isThePasswordContainingDigits(String password) {


        int numCount = 0;
        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (isNumeric(ch)) numCount++;
        }


        return (numCount >= 1);
    }

    public static boolean isThePasswordContainingCapitals(String password) {

        int capitalCharCount = 0;
        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (isCapitalLetter(ch)) capitalCharCount++;
        }


        return (capitalCharCount >= 1);
    }

    public static boolean isThePasswordContainingLowercaseChars(String password) {

        int lowercaseCharCount = 0;
        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (isLowercaseLetter(ch)) lowercaseCharCount++;
        }


        return (lowercaseCharCount >= 1);
    }

    public static boolean isThePasswordContainingSigns(String password) {

        int signCount = 0;
        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (isASign(ch)) signCount++;
        }


        return (signCount >= 1);
    }

    public static boolean isThePasswordLengthValid(String password) {

        return (password.length() >= 8);

    }

    private static boolean isNumeric(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static boolean isCapitalLetter(char ch) {
        return (ch >= 'A' && ch <= 'Z');
    }

    public static boolean isLowercaseLetter(char ch) {
        return (ch >= 'a' && ch <= 'z');
    }

    public static boolean isASign(char ch) {
        return (ch >= '!' && ch <= '/' || ch >= ':' && ch <= '@');
    }
}