package com.example.ww2inyourhands;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class StartMenu extends AppCompatActivity {

    Button playBtn, hallOfFameBtn, connectAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);

        playBtn = findViewById(R.id.play_button);
        hallOfFameBtn = findViewById(R.id.hall_of_fame_button);
        connectAccount = findViewById(R.id.connect_account_button);


        connectAccount.setOnClickListener(v-> startActivity(new Intent(StartMenu.this, CreateAccountActivity.class)));
        playBtn.setOnClickListener(v-> startActivity(new Intent(StartMenu.this, GameScene1Activity.class)));
    }


}