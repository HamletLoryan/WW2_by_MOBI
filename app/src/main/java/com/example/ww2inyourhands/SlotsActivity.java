package com.example.ww2inyourhands;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

public class SlotsActivity extends AppCompatActivity {

    // TODO: make the buttons text recognizable

    Button slotOneBtn, slotTwoBtn, slotThreeBtn, autoSaveBtn, backButton;
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
        backButton = findViewById(R.id.back_btn);

        backButton.setOnClickListener(v -> startActivity(new Intent(SlotsActivity.this, StartNewOrContinueActivity.class)));


        autoSaveButton();
        slot1Button();
        slot2Button();
        slot3Button();
    }

    @SuppressLint("SetTextI18n")
    public void autoSaveButton(){
        SharedPreferences sp = this.getSharedPreferences("Saves", MODE_PRIVATE);
        String slot = sp.getString("AutoSave", null);

        if (slot == null){
            autoSaveBtn.setBackgroundColor(Color.rgb(153, 153, 153));
            autoSaveBtn.setTextColor(Color.rgb(51, 51, 51));
            autoSaveBtn.setOnClickListener(v -> {});
        }
        else {
            autoSaveBtn.setText("Auto save: \n" + slot);
            autoSaveBtn.setOnClickListener(v -> {
                AutoSave = true;
                startActivity(new Intent(SlotsActivity.this, GameScene.class));
            });
        }

    }
    @SuppressLint("SetTextI18n")
    public void slot1Button(){
        SharedPreferences sp = this.getSharedPreferences("Saves", MODE_PRIVATE);
        String slot = sp.getString("SaveSlot1", null);

        if (slot == null){
            slotOneBtn.setBackgroundColor(Color.rgb(153, 153, 153));
            slotOneBtn.setTextColor(Color.rgb(36, 36, 36));
            slotOneBtn.setOnClickListener(v -> {});
        }
        else {
            slotOneBtn.setText("Slot 1: \n" + slot);
            slotOneBtn.setOnClickListener(v -> {
                Slot1 = true;
                startActivity(new Intent(SlotsActivity.this, GameScene.class));
            });
        }

    }
    @SuppressLint("SetTextI18n")
    public void slot2Button(){
        SharedPreferences sp = this.getSharedPreferences("Saves", MODE_PRIVATE);
        String slot = sp.getString("SaveSlot2", null);

        if (slot == null){
            slotTwoBtn.setBackgroundColor(Color.rgb(153, 153, 153));
            slotTwoBtn.setTextColor(Color.rgb(36, 36, 36));
            slotTwoBtn.setOnClickListener(v -> {});
        }
        else {
            slotTwoBtn.setText("Slot 2: \n" + slot);
            slotTwoBtn.setOnClickListener(v -> {
                Slot2 = true;
                startActivity(new Intent(SlotsActivity.this, GameScene.class));
            });
        }

    }
    @SuppressLint("SetTextI18n")
    public void slot3Button(){
        SharedPreferences sp = this.getSharedPreferences("Saves", MODE_PRIVATE);
        String slot = sp.getString("SaveSlot3", null);

        if (slot == null){
            slotThreeBtn.setBackgroundColor(Color.rgb(153, 153, 153));
            slotThreeBtn.setTextColor(Color.rgb(36, 36, 36));
            slotThreeBtn.setOnClickListener(v -> {});
        }
        else {
            slotThreeBtn.setText("Slot 3: \n" + slot);
            slotThreeBtn.setOnClickListener(v -> {
                Slot3 = true;
                startActivity(new Intent(SlotsActivity.this, GameScene.class));
            });
        }

    }
    @Override
    public void onBackPressed(){

    }

}