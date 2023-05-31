package com.example.ww2inyourhands;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;

import java.io.IOException;
import java.util.Objects;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        try {
            if(isOnline()){
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
                            getSaves();
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
            }else{
                Toast.makeText(LoadingActivity.this, R.string.you_are_offline_now, Toast.LENGTH_LONG).show();
                new Handler().postDelayed(() -> startActivity(new Intent(LoadingActivity
                        .this, StartMenu.class)), 1000

                );
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean isOnline() throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
        int     exitValue = ipProcess.waitFor();
        return (exitValue == 0);

    }
    public void getSaves(){
        DocumentReference dr = Utilities.getDocumentReference();
        dr.get().addOnSuccessListener(documentSnapshot -> {
            Saves save = documentSnapshot.toObject(Saves.class);
            assert save != null;
            SharedPreferences sharedPreferences = getSharedPreferences("Saves", MODE_PRIVATE);
            SharedPreferences.Editor Ed = sharedPreferences.edit();
            if (!save.getSaveSlot1().equals("Empty"))Ed.putString("SaveSlot1", save.getSaveSlot1());
            if (!save.getSaveSlot2().equals("Empty"))Ed.putString("SaveSlot2", save.getSaveSlot2());
            if (!save.getSaveSlot3().equals("Empty"))Ed.putString("SaveSlot3", save.getSaveSlot3());
            Ed.apply();
        });
    }


}
