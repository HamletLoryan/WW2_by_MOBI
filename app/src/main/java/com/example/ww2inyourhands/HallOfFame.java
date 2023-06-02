package com.example.ww2inyourhands;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class HallOfFame extends AppCompatActivity {

    public static boolean isMineAchieved = false;


    Button backButton;

    ImageButton MineEnding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hall_of_fame);

        backButton = findViewById(R.id.back_btn);
        backButton.setOnClickListener(v -> startActivity(new Intent(HallOfFame.this, StartMenu.class)));
        MineEnding = findViewById(R.id.mine_ending);

        SharedPreferences sp = getSharedPreferences("Endings", MODE_PRIVATE);
        HallOfFame.isMineAchieved = sp.getBoolean("Mine", false);
        updateEndings();
    }

    private void updateEndings() {
        if(HallOfFame.isMineAchieved){
            MineEnding.setImageResource(R.drawable.mine_explosion);
            MineEnding.setOnClickListener(v -> Toast.makeText(this, "Mine is achieved", Toast.LENGTH_SHORT).show());
            MineEnding.setBackgroundResource(R.drawable.background);
        }
        else{
            MineEnding.setImageResource(R.drawable.padlock);
            MineEnding.setOnClickListener(v -> Toast.makeText(this, "Mine is not achieved", Toast.LENGTH_SHORT).show());
            MineEnding.setBackgroundResource(R.drawable.background3);
        }
    }

    @Override
    public void onBackPressed(){}
}