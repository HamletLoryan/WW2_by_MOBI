package com.example.ww2inyourhands;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);


        SharedPreferences sp = this.getSharedPreferences("Login", MODE_PRIVATE);
        boolean isLoggedIn = sp.getBoolean("IsLoggedIn", false);
        if (isLoggedIn) {
            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
            String email = sp.getString("Email", null);
            String password = sp.getString("Password", null);
            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    if (Objects.requireNonNull(firebaseAuth.getCurrentUser()).isEmailVerified()) {
                        LoginActivity.loggedIn = true;
                        startActivity(new Intent(LoadingActivity.this, StartMenu.class));
                        finish();
                    } else {
                        Toast.makeText(LoadingActivity.this, Objects.requireNonNull(
                                task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoadingActivity.this, Objects.requireNonNull(
                            task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                }
            });


        }else{
            new Handler().postDelayed(() -> startActivity(new Intent(LoadingActivity
                    .this, StartMenu.class)), 1000

            );
        }
    }
}
