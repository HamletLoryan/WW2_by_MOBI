package com.example.ww2inyourhands;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class GameStartActivity extends AppCompatActivity {

    Button okBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_start);

        okBtn = findViewById(R.id.ok_button);
        okBtn.setOnClickListener(v-> startActivity(new Intent(GameStartActivity.this, GameScene.class)));
    }
}