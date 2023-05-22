package com.example.ww2inyourhands;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;

public class StartNewOrContinueActivity extends AppCompatActivity {
    Button newGameBtn, continueBtn, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_new_or_continue);
        if(!LoginActivity.loggedIn){
            showDialog(StartNewOrContinueActivity.this);
        }





        continueBtn = findViewById(R.id.continue_button);
        newGameBtn = findViewById(R.id.new_game_button);
        backButton = findViewById(R.id.back_btn);
        newGameBtn.setOnClickListener(v-> startActivity(new Intent(StartNewOrContinueActivity.this, GameScene.class)));
        continueBtn.setOnClickListener(v-> startActivity(new Intent(StartNewOrContinueActivity.this, SlotsActivity.class)));
        backButton.setOnClickListener(v -> startActivity(new Intent(StartNewOrContinueActivity.this, StartMenu.class)));


    }

    private void showDialog(Activity activity) {

        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.not_logged_in_dialog_otp);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button dialogBtn_continue = dialog.findViewById(R.id.continue_btn);
        dialogBtn_continue.setOnClickListener(v -> dialog.dismiss());
        Button dialogBtn_log_in = dialog.findViewById(R.id.log_in_btn);
        dialogBtn_log_in.setOnClickListener(v -> {
            startActivity(new Intent(StartNewOrContinueActivity.this, LoginActivity.class));
            dialog.dismiss();
        });
        dialog.show();
    }


}