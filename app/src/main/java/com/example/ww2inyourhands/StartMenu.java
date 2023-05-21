package com.example.ww2inyourhands;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class StartMenu extends AppCompatActivity {

    Button playBtn, hallOfFameBtn, accountBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);

        playBtn = findViewById(R.id.play_button);
        hallOfFameBtn = findViewById(R.id.hall_of_fame_button);
        accountBtn = findViewById(R.id.account_button);


        accountBtn.setOnClickListener(v-> accountButton(LoginActivity.loggedIn));
        playBtn.setOnClickListener(v-> startActivity(new Intent(StartMenu.this, StartNewOrContinueActivity.class)));


        }

    private void accountButton(boolean loggedIn) {
        if (loggedIn){
            startActivity(new Intent(StartMenu.this, AccountActivity.class));
        }
        else{
            startActivity(new Intent(StartMenu.this, LoginActivity.class));
        }
    }

    @Override
    public void onBackPressed(){

    }





}