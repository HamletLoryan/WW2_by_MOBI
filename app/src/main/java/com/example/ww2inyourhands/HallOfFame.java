package com.example.ww2inyourhands;


import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
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
            MineEnding.setOnClickListener(v -> {
                showEndingDialog(HallOfFame.this, R.drawable.mine_explosion, R.drawable.background, R.string.mine_ending_text);
            });
            MineEnding.setBackgroundResource(R.drawable.background);
        }
        else{
            MineEnding.setImageResource(R.drawable.padlock);
            MineEnding.setOnClickListener(v -> {
                showEndingDialog(HallOfFame.this, R.drawable.padlock, R.drawable.background3, R.string.this_ending_is_not_achieved_yet);
            });
            MineEnding.setBackgroundResource(R.drawable.background3);
        }
    }

    public void showEndingDialog(Activity activity, int imageRes, int backgroundRes, int textRes){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.ending_dialog_otp);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ImageView imageView = dialog.findViewById(R.id.dialog_image);
        TextView textView = dialog.findViewById(R.id.dialog_text);
        Button backBtn = dialog.findViewById(R.id.back_btn);
        imageView.setImageResource(imageRes);
        imageView.setBackgroundResource(backgroundRes);
        textView.setText(textRes);
        backBtn.setOnClickListener(v -> dialog.dismiss());
        dialog.show();
    }

    @Override
    public void onBackPressed(){}
}