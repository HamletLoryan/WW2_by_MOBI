package com.example.ww2inyourhands;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {
                                          startActivity(new Intent(LoadingActivity.this, StartMenu.class));
                                      }
                                  }, 1000

        );
    }
}