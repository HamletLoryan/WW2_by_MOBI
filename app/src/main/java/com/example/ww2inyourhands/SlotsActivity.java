package com.example.ww2inyourhands;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SlotsActivity extends AppCompatActivity {

    Button slotOneBtn, slotTwoBtn, slotThreeBtn, autoSaveBtn;
    public static boolean Slot1 = false;
    public static boolean Slot2 = false;
    public static boolean Slot3 = false;
    public static boolean AutoSave = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slots);
         slotOneBtn = findViewById(R.id.slot1);
         slotTwoBtn = findViewById(R.id.slot2);
         slotThreeBtn = findViewById(R.id.slot3);
         autoSaveBtn = findViewById(R.id.autoSave);

         autoSaveBtn.setOnClickListener(v -> {
             AutoSave = true;
             startActivity(new Intent(SlotsActivity.this, GameScene.class));
         });
        slotOneBtn.setOnClickListener(v -> {
            Slot1 = true;
            startActivity(new Intent(SlotsActivity.this, GameScene.class));
        });
        slotTwoBtn.setOnClickListener(v -> {
            Slot2 = true;
            startActivity(new Intent(SlotsActivity.this, GameScene.class));
        });
        slotThreeBtn.setOnClickListener(v -> {
            Slot3 = true;
            startActivity(new Intent(SlotsActivity.this, GameScene.class));
        });
    }

}