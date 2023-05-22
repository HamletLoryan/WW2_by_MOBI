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

import java.io.IOException;

public class StartMenu extends AppCompatActivity {

    Button playBtn, hallOfFameBtn, accountBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);

        try {
            if(!isOnline()) showDialog(StartMenu.this);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        playBtn = findViewById(R.id.play_button);
        hallOfFameBtn = findViewById(R.id.hall_of_fame_button);
        accountBtn = findViewById(R.id.account_button);


        accountBtn.setOnClickListener(v-> accountButton(LoginActivity.loggedIn));
        playBtn.setOnClickListener(v-> startActivity(new Intent(StartMenu.this, StartNewOrContinueActivity.class)));


        }

    private void accountButton(boolean loggedIn) {
        if (loggedIn){
            startActivity(new Intent(StartMenu.this, AccountActivity.class));
        }
        else{
            startActivity(new Intent(StartMenu.this, LoginActivity.class));
        }
    }

    @Override
    public void onBackPressed(){

    }
    private void showDialog(Activity activity) {

        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.offline_start_dialog_otp);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button dialogBtn_continue = dialog.findViewById(R.id.ok_btn);
        dialogBtn_continue.setOnClickListener(v -> dialog.dismiss());
        Button dialogBtn_log_in = dialog.findViewById(R.id.close_btn);
        dialogBtn_log_in.setOnClickListener(v -> {
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        });
        dialog.show();
    }

    public boolean isOnline() throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
        int     exitValue = ipProcess.waitFor();
        return (exitValue == 0);

    }

    /* TODO: make a close app function */





}