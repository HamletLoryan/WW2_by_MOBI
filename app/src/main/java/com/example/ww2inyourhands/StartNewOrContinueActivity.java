package com.example.ww2inyourhands;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class StartNewOrContinueActivity extends AppCompatActivity {
    Button newGameBtn, continueBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_new_or_continue);

        continueBtn = findViewById(R.id.continue_button);
        newGameBtn = findViewById(R.id.new_game_button);
        newGameBtn.setOnClickListener(v-> startActivity(new Intent(StartNewOrContinueActivity.this, GameScene.class)));
        continueBtn.setOnClickListener(v-> startActivity(new Intent(StartNewOrContinueActivity.this, SlotsActivity.class)));
    }


}