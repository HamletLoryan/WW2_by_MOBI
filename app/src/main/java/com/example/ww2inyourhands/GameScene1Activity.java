package com.example.ww2inyourhands;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameScene1Activity extends AppCompatActivity {

    Button okBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_scene1);

        okBtn = findViewById(R.id.ok_button);
        okBtn.setOnClickListener(v-> startActivity(new Intent(GameScene1Activity.this, GameScene2Activity.class)));
    }
}