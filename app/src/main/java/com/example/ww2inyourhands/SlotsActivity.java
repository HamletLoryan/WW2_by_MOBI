package com.example.ww2inyourhands;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentReference;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class SlotsActivity extends AppCompatActivity {


    Button slotOneBtn, slotTwoBtn, slotThreeBtn, autoSaveBtn, backButton, deleteAllBtn;
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
        deleteAllBtn = findViewById(R.id.delete_btn);

        backButton.setOnClickListener(v -> startActivity(new Intent(SlotsActivity.this, StartNewOrContinueActivity.class)));
        deleteAllBtn.setOnClickListener(v -> showDeletingDialog(SlotsActivity.this));


        autoSaveButton();
        slot1Button();
        slot2Button();
        slot3Button();
    }

    private void showDeletingDialog(Activity activity) {
        final Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(true);
            dialog.setContentView(R.layout.delete_all_dialog_otp);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            Button dialogBtn_delete = dialog.findViewById(R.id.delete_btn);
            dialogBtn_delete.setOnClickListener(v -> {
                        SharedPreferences sp = this.getSharedPreferences("Saves", MODE_PRIVATE);
                        SharedPreferences.Editor Ed = sp.edit();
                        Ed.putString("SaveSlot3", null);
                        Ed.putString("SaveSlot2", null);
                        Ed.putString("SaveSlot1", null);
                        Ed.putString("AutoSave", null);
                        startActivity(new Intent(SlotsActivity.this, SlotsActivity.class));
                        Ed.apply();

                        SharedPreferences login = this.getSharedPreferences("Login", MODE_PRIVATE);
                        boolean isLoggedIn = login.getBoolean("IsLoggedIn", false);

                        if(isLoggedIn){DocumentReference documentReference;
                        documentReference = Utilities.getDocumentReference();
                        Map<String, Object> save = new HashMap<>();
                        save.put("SaveSlot1", "Empty");
                        save.put("SaveSlot2", "Empty");
                        save.put("SaveSlot3", "Empty");

                        documentReference.update(save).addOnCompleteListener(task -> {
                            if (!task.isSuccessful()) {
                                Toast.makeText(SlotsActivity.this, Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    dialog.dismiss();
            });
            Button dialogBtn_cancel = dialog.findViewById(R.id.cancel_btn);
            dialogBtn_cancel.setOnClickListener(v -> dialog.dismiss());
            dialog.show();

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