package com.example.ww2inyourhands;


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

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.DocumentReference;

import java.util.HashMap;
import java.util.Map;

public class HallOfFame extends AppCompatActivity {

    public static boolean isMineAchieved = false;
    public static boolean isHeroAchieved = false;
    public static boolean isCampInfiltrationAchieved = false;
    public static boolean isTreasureAchieved = false;
    public static boolean isInterceptionAchieved = false;
    public static boolean isComingSoonAchieved = false;


    Button backButton;

    ImageButton MineEnding, HeroEnding, InterceptionEnding, CampInfiltrationEnding, ComingSoonEnding, TreasureEnding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hall_of_fame);

        backButton = findViewById(R.id.back_btn);
        backButton.setOnClickListener(v -> startActivity(new Intent(HallOfFame.this, StartMenu.class)));
        MineEnding = findViewById(R.id.mine_ending);
        HeroEnding = findViewById(R.id.hero_ending);
        InterceptionEnding = findViewById(R.id.interception_ending);
        CampInfiltrationEnding = findViewById(R.id.camp_infiltration_ending);
        ComingSoonEnding = findViewById(R.id.coming_soon_ending);
        TreasureEnding = findViewById(R.id.treasure_ending);

        if (LoginActivity.loggedIn) getEndings();

        SharedPreferences sp = getSharedPreferences("Endings", MODE_PRIVATE);
        HallOfFame.isMineAchieved = sp.getBoolean("Mine", false);
        HallOfFame.isComingSoonAchieved = sp.getBoolean("Coming soon", false);
        HallOfFame.isTreasureAchieved = sp.getBoolean("Treasure", false);
        HallOfFame.isInterceptionAchieved = sp.getBoolean("Interception", false);
        HallOfFame.isHeroAchieved = sp.getBoolean("Hero", false);
        HallOfFame.isCampInfiltrationAchieved = sp.getBoolean("Camp infiltration", false);
        updateEndings();
    }

    private void updateEndings() {
        if (isMineAchieved) {
            MineEnding.setImageResource(R.drawable.mine_explosion);
            MineEnding.setOnClickListener(v -> showEndingDialog(HallOfFame.this, R.drawable.mine_explosion, R.drawable.background, R.string.mine_ending_text));
            MineEnding.setBackgroundResource(R.drawable.background);
        } else {
            MineEnding.setImageResource(R.drawable.padlock);
            MineEnding.setOnClickListener(v -> showEndingDialog(HallOfFame.this, R.drawable.padlock, R.drawable.background3, R.string.this_ending_is_not_achieved_yet));
            MineEnding.setBackgroundResource(R.drawable.background3);
        }

        if (isHeroAchieved) {
            HeroEnding.setImageResource(R.drawable.achievement);
            HeroEnding.setOnClickListener(v -> showEndingDialog(HallOfFame.this, R.drawable.achievement, R.drawable.background, R.string.hero_ending_text));
            HeroEnding.setBackgroundResource(R.drawable.background);
        } else {
            HeroEnding.setImageResource(R.drawable.padlock);
            HeroEnding.setOnClickListener(v -> showEndingDialog(HallOfFame.this, R.drawable.padlock, R.drawable.background3, R.string.this_ending_is_not_achieved_yet));
            HeroEnding.setBackgroundResource(R.drawable.background3);
        }
        if (isCampInfiltrationAchieved) {
            CampInfiltrationEnding.setImageResource(R.drawable.medal);
            CampInfiltrationEnding.setOnClickListener(v -> showEndingDialog(HallOfFame.this, R.drawable.medal, R.drawable.background, R.string.camp_infiltration_ending_text));
            CampInfiltrationEnding.setBackgroundResource(R.drawable.background);
        } else {
            CampInfiltrationEnding.setImageResource(R.drawable.padlock);
            CampInfiltrationEnding.setOnClickListener(v -> showEndingDialog(HallOfFame.this, R.drawable.padlock, R.drawable.background3, R.string.this_ending_is_not_achieved_yet));
            CampInfiltrationEnding.setBackgroundResource(R.drawable.background3);
        }
        if (isTreasureAchieved) {
            TreasureEnding.setImageResource(R.drawable.open_treasure_chest);
            TreasureEnding.setOnClickListener(v -> showEndingDialog(HallOfFame.this, R.drawable.open_treasure_chest, R.drawable.background, R.string.treasure_ending_text));
            TreasureEnding.setBackgroundResource(R.drawable.background);
        } else {
            TreasureEnding.setImageResource(R.drawable.padlock);
            TreasureEnding.setOnClickListener(v -> showEndingDialog(HallOfFame.this, R.drawable.padlock, R.drawable.background3, R.string.this_ending_is_not_achieved_yet));
            TreasureEnding.setBackgroundResource(R.drawable.background3);
        }
        if (isInterceptionAchieved) {
            InterceptionEnding.setImageResource(R.drawable.hasty_grave);
            InterceptionEnding.setOnClickListener(v -> showEndingDialog(HallOfFame.this, R.drawable.hasty_grave, R.drawable.background, R.string.interception_ending_text));
            InterceptionEnding.setBackgroundResource(R.drawable.background);
        } else {
            InterceptionEnding.setImageResource(R.drawable.padlock);
            InterceptionEnding.setOnClickListener(v -> showEndingDialog(HallOfFame.this, R.drawable.padlock, R.drawable.background3, R.string.this_ending_is_not_achieved_yet));
            InterceptionEnding.setBackgroundResource(R.drawable.background3);
        }
        if (isComingSoonAchieved) {
            ComingSoonEnding.setImageResource(R.drawable.coming_soon);
            ComingSoonEnding.setOnClickListener(v -> showEndingDialog(HallOfFame.this, R.drawable.coming_soon, R.drawable.background, R.string.coming_soon_ending_text));
            ComingSoonEnding.setBackgroundResource(R.drawable.background);
        } else {
            ComingSoonEnding.setImageResource(R.drawable.padlock);
            ComingSoonEnding.setOnClickListener(v -> showEndingDialog(HallOfFame.this, R.drawable.padlock, R.drawable.background3, R.string.this_ending_is_not_achieved_yet));
            ComingSoonEnding.setBackgroundResource(R.drawable.background3);
        }

    }

    public void showEndingDialog(Activity activity, int imageRes, int backgroundRes, int textRes) {
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
    public void onBackPressed() {
    }

    public void getEndings() {
        DocumentReference dr = Utilities.getDocumentReferenceForEndings();
        dr.get().addOnSuccessListener(documentSnapshot -> {
            Endings dataBaseEndings = documentSnapshot.toObject(Endings.class);
            assert dataBaseEndings != null;
            Map<String, Object> Endings = new HashMap<>();
            setMine(dataBaseEndings.isMine());
            Endings.put("Mine", isMineAchieved);
            setHero(dataBaseEndings.isHero());
            Endings.put("Hero", isHeroAchieved);
            setInterception(dataBaseEndings.isInterception());
            Endings.put("Interception", isInterceptionAchieved);
            setTreasure(dataBaseEndings.isTreasure());
            Endings.put("Treasure", isTreasureAchieved);
            setCampInfiltration(dataBaseEndings.isCampInfiltration());
            Endings.put("Camp infiltration", isCampInfiltrationAchieved);
            setComingSoon(dataBaseEndings.isComingSoon());
            Endings.put("Coming soon", isComingSoonAchieved);

            dr.update(Endings);
        });
    }

    private void setMine(boolean isEndingAchieved) {
        if (isEndingAchieved && !isMineAchieved) {
            isMineAchieved = true;
            SharedPreferences sp = getSharedPreferences("Endings", MODE_PRIVATE);
            SharedPreferences.Editor Ed = sp.edit();
            Ed.putBoolean("Mine", true);
            Ed.apply();
        }
    }

    private void setHero(boolean isEndingAchieved) {
        if (isEndingAchieved && !isHeroAchieved) {
            isHeroAchieved = true;
            SharedPreferences sp = getSharedPreferences("Endings", MODE_PRIVATE);
            SharedPreferences.Editor Ed = sp.edit();
            Ed.putBoolean("Hero", true);
            Ed.apply();
        }
    }

    private void setInterception(boolean isEndingAchieved) {
        if (isEndingAchieved && !isInterceptionAchieved) {
            isInterceptionAchieved = true;
            SharedPreferences sp = getSharedPreferences("Endings", MODE_PRIVATE);
            SharedPreferences.Editor Ed = sp.edit();
            Ed.putBoolean("Interception", true);
            Ed.apply();
        }
    }

    private void setTreasure(boolean isEndingAchieved) {
        if (isEndingAchieved && !isTreasureAchieved) {
            isTreasureAchieved = true;
            SharedPreferences sp = getSharedPreferences("Endings", MODE_PRIVATE);
            SharedPreferences.Editor Ed = sp.edit();
            Ed.putBoolean("Treasure", true);
            Ed.apply();
        }
    }

    private void setCampInfiltration(boolean isEndingAchieved) {
        if (isEndingAchieved && !isCampInfiltrationAchieved) {
            isCampInfiltrationAchieved = true;
            SharedPreferences sp = getSharedPreferences("Endings", MODE_PRIVATE);
            SharedPreferences.Editor Ed = sp.edit();
            Ed.putBoolean("Camp infiltration", true);
            Ed.apply();
        }
    }

    private void setComingSoon(boolean isEndingAchieved) {
        if (isEndingAchieved && !isComingSoonAchieved) {
            isComingSoonAchieved = true;
            SharedPreferences sp = getSharedPreferences("Endings", MODE_PRIVATE);
            SharedPreferences.Editor Ed = sp.edit();
            Ed.putBoolean("Coming soon", true);
            Ed.apply();
        }
    }
}