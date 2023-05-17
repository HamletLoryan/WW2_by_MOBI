package com.example.ww2inyourhands;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameScene extends AppCompatActivity {
    Story story = new Story(this);

    ImageView sceneImage;
    TextView sceneText;
    Button variantABtn, variantBBtn, variantCBtn, variantDBtn, saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_scene);

        sceneImage = findViewById(R.id.image);
        sceneText = findViewById(R.id.text);
        variantABtn = (Button)findViewById(R.id.varA);
        variantBBtn = (Button)findViewById(R.id.varB);
        variantCBtn = (Button)findViewById(R.id.varC);
        variantDBtn = (Button)findViewById(R.id.varD);
        saveBtn = (Button)findViewById(R.id.saveBtn);


        variantABtn.setTransformationMethod(null);
        variantBBtn.setTransformationMethod(null);
        variantCBtn.setTransformationMethod(null);
        variantDBtn.setTransformationMethod(null);

        if (SlotsActivity.Slot1){
            SharedPreferences sp = this.getSharedPreferences("Saves", MODE_PRIVATE);
            String currentPosition = sp.getString("SaveSlot1", null);
            story.setPosition(currentPosition);
            SlotsActivity.Slot1 = false;
        }else if (SlotsActivity.Slot2){
            SharedPreferences sp = this.getSharedPreferences("Saves", MODE_PRIVATE);
            String currentPosition = sp.getString("SaveSlot2", null);
            story.setPosition(currentPosition);
            SlotsActivity.Slot2 = false;
        }else if (SlotsActivity.Slot3){
            SharedPreferences sp = this.getSharedPreferences("Saves", MODE_PRIVATE);
            String currentPosition = sp.getString("SaveSlot3", null);
            story.setPosition(currentPosition);
            SlotsActivity.Slot3 = false;
        }else if (SlotsActivity.AutoSave){
            SharedPreferences sp = this.getSharedPreferences("Saves", MODE_PRIVATE);
            String currentPosition = sp.getString("AutoSave", null);
            story.setPosition(currentPosition);
            SlotsActivity.AutoSave = false;
        }else {
            story.startPoint();
        }
//        story.startPoint();



        variantABtn.setOnClickListener(v-> varA());
        variantBBtn.setOnClickListener(v-> varB());
        variantCBtn.setOnClickListener(v-> varC());
        variantDBtn.setOnClickListener(v-> varD());
        saveBtn.setOnClickListener(v->
                showDialog(GameScene.this));



    }


    public void varA(){

        SharedPreferences sp=getSharedPreferences("Saves", MODE_PRIVATE);
        SharedPreferences.Editor Ed=sp.edit();
        story.setPosition(story.nextPositionA);
        Ed.putString("AutoSave", story.nextPositionA );
        Ed.apply();
    }
    public void varB(){

        SharedPreferences sp=getSharedPreferences("Saves", MODE_PRIVATE);
        SharedPreferences.Editor Ed=sp.edit();
        story.setPosition(story.nextPositionB);
        Ed.putString("AutoSave", story.nextPositionB );
        Ed.apply();
    }
    public void varC(){

        SharedPreferences sp=getSharedPreferences("Saves", MODE_PRIVATE);
        SharedPreferences.Editor Ed=sp.edit();
        story.setPosition(story.nextPositionC);
        Ed.putString("AutoSave", story.nextPositionC );
        Ed.apply();
    }
    public void varD(){

        SharedPreferences sp=getSharedPreferences("Saves", MODE_PRIVATE);
        SharedPreferences.Editor Ed=sp.edit();
        story.setPosition(story.nextPositionD);
        Ed.putString("AutoSave", story.nextPositionD );
        Ed.apply();
    }

    public void showDialog(Activity activity){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.custom_dialogbox_otp);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        SharedPreferences sp=getSharedPreferences("Saves", MODE_PRIVATE);
        SharedPreferences.Editor Ed=sp.edit();
        Button dialogBtn_slot_1 = (Button) dialog.findViewById(R.id.slot1);
        dialogBtn_slot_1.setOnClickListener(v -> {
            Ed.putString("SaveSlot1", story.currentPosition );
            Ed.apply();
            Toast.makeText(GameScene.this, "Save 1 saved successful", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });
        Button dialogBtn_slot_2 = (Button) dialog.findViewById(R.id.slot2);
        dialogBtn_slot_2.setOnClickListener(v -> {
            Ed.putString("SaveSlot2", story.currentPosition );
            Ed.apply();
            Toast.makeText(GameScene.this, "Save 2 saved successful", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });Button dialogBtn_slot_3 = (Button) dialog.findViewById(R.id.slot3);
        dialogBtn_slot_3.setOnClickListener(v -> {
            Ed.putString("SaveSlot3", story.currentPosition );
            Ed.apply();
            Toast.makeText(GameScene.this, "Save 3 saved successful", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });
        dialog.show();
    }

}