package com.example.ww2inyourhands;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class StartNewOrContinueActivity extends AppCompatActivity {
    Button newGameBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_new_or_continue);

        newGameBtn = findViewById(R.id.new_game_button);
        newGameBtn.setOnClickListener(v-> startActivity(new Intent(StartNewOrContinueActivity.this, GameScene.class)));
    }


}