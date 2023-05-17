package com.example.ww2inyourhands;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class StartMenu extends AppCompatActivity {

    Button playBtn, hallOfFameBtn, connectAccount, accountBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);

        playBtn = findViewById(R.id.play_button);
        accountBtn = findViewById(R.id.account_button);
        hallOfFameBtn = findViewById(R.id.hall_of_fame_button);
        connectAccount = findViewById(R.id.connect_account_button);

        accountBtn.setVisibility(INVISIBLE);


        connectAccount.setOnClickListener(v-> startActivity(new Intent(StartMenu.this, CreateAccountActivity.class)));
        accountBtn.setOnClickListener(v-> startActivity(new Intent(StartMenu.this, AccountActivity.class)));
        playBtn.setOnClickListener(v-> startActivity(new Intent(StartMenu.this, StartNewOrContinueActivity.class)));


        }




    @Override
    protected void onResume() {
        if (LoginActivity.loggedIn){
            connectAccount.setVisibility(INVISIBLE);
            accountBtn.setVisibility(VISIBLE);
        }
        super.onResume();
    }


}