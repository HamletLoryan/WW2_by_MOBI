package com.example.ww2inyourhands;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SlotsActivity extends AppCompatActivity {

    Button btn1;
    Story story;
    WorkingWithSaves wws;
    Context ctx = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slots);

        btn1 = findViewById(R.id.slot1);

        btn1.setOnClickListener(v-> btn1());
    }


    public void btn1(){
        startActivity(new Intent(SlotsActivity.this, GameScene.class));
        story.setPosition(wws.getSaveOne(ctx));
    }
}