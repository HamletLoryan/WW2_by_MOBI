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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.DocumentReference;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GameScene extends AppCompatActivity {
    Story story = new Story(this);

    ImageView sceneImage;
    TextView sceneText;
    Button variantABtn, variantBBtn, variantCBtn, variantDBtn, menuBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_scene);

        sceneImage = findViewById(R.id.image);
        sceneText = findViewById(R.id.text);
        variantABtn = findViewById(R.id.varA);
        variantBBtn = findViewById(R.id.varB);
        variantCBtn = findViewById(R.id.varC);
        variantDBtn = findViewById(R.id.varD);
        menuBtn = findViewById(R.id.menuBtn);


        variantABtn.setTransformationMethod(null);
        variantBBtn.setTransformationMethod(null);
        variantCBtn.setTransformationMethod(null);
        variantDBtn.setTransformationMethod(null);

        if (SlotsActivity.Slot1) {
            SharedPreferences sp = this.getSharedPreferences("Saves", MODE_PRIVATE);
            String currentPosition = sp.getString("SaveSlot1", null);
            story.setPosition(currentPosition);
            SlotsActivity.Slot1 = false;
        } else if (SlotsActivity.Slot2) {
            SharedPreferences sp = this.getSharedPreferences("Saves", MODE_PRIVATE);
            String currentPosition = sp.getString("SaveSlot2", null);
            story.setPosition(currentPosition);
            SlotsActivity.Slot2 = false;
        } else if (SlotsActivity.Slot3) {
            SharedPreferences sp = this.getSharedPreferences("Saves", MODE_PRIVATE);
            String currentPosition = sp.getString("SaveSlot3", null);
            story.setPosition(currentPosition);
            SlotsActivity.Slot3 = false;
        } else if (SlotsActivity.AutoSave) {
            SharedPreferences sp = this.getSharedPreferences("Saves", MODE_PRIVATE);
            String currentPosition = sp.getString("AutoSave", null);
            story.setPosition(currentPosition);
            SlotsActivity.AutoSave = false;
        } else {
            story.startPoint();
        }


        variantABtn.setOnClickListener(v -> varA());
        variantBBtn.setOnClickListener(v -> varB());
        variantCBtn.setOnClickListener(v -> varC());
        variantDBtn.setOnClickListener(v -> varD());
        menuBtn.setOnClickListener(v ->
                showMenuDialog(GameScene.this));


    }


    public void varA() {

        SharedPreferences sp = getSharedPreferences("Saves", MODE_PRIVATE);
        SharedPreferences.Editor Ed = sp.edit();
        story.setPosition(story.nextPositionA);
        Ed.putString("AutoSave", story.nextPositionA);
        Ed.apply();
    }

    public void varB() {

        SharedPreferences sp = getSharedPreferences("Saves", MODE_PRIVATE);
        SharedPreferences.Editor Ed = sp.edit();
        story.setPosition(story.nextPositionB);
        Ed.putString("AutoSave", story.nextPositionB);
        Ed.apply();
    }

    public void varC() {

        SharedPreferences sp = getSharedPreferences("Saves", MODE_PRIVATE);
        SharedPreferences.Editor Ed = sp.edit();
        story.setPosition(story.nextPositionC);
        Ed.putString("AutoSave", story.nextPositionC);
        Ed.apply();
    }

    public void varD() {

        SharedPreferences sp = getSharedPreferences("Saves", MODE_PRIVATE);
        SharedPreferences.Editor Ed = sp.edit();
        story.setPosition(story.nextPositionD);
        Ed.putString("AutoSave", story.nextPositionD);
        Ed.apply();
    }

    public void showSavesDialog(Activity activity) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.saves_dialogbox_otp);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        SharedPreferences sp = getSharedPreferences("Saves", MODE_PRIVATE);
        SharedPreferences sp1 = getSharedPreferences("Login", MODE_PRIVATE);
        SharedPreferences.Editor Ed = sp.edit();
        Button dialogBtn_slot_1 = dialog.findViewById(R.id.slot1);
        String slot1 = sp.getString("SaveSlot1", "Empty");
        String slot2 = sp.getString("SaveSlot2", "Empty");
        String slot3 = sp.getString("SaveSlot3", "Empty");
        if (slot1.equals("Empty")) {
            dialogBtn_slot_1.setBackgroundColor(Color.rgb(153, 153, 153));
            dialogBtn_slot_1.setTextColor(Color.rgb(51, 51, 51));
            dialogBtn_slot_1.setOnClickListener(view -> {
                Saves saves = new Saves();
                saves.setSaveSlot3(slot3);
                saves.setSaveSlot2(slot2);
                saves.setSaveSlot1(story.currentPosition);
                if (sp1.getBoolean("IsLoggedIn", false)) saveToDatabase(saves);
                Ed.putString("SaveSlot1", story.currentPosition);
                Ed.apply();
                Toast.makeText(GameScene.this, R.string.save_1_saved_successfully, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            });
        } else {
            dialogBtn_slot_1.setOnClickListener(view -> {
                showSaveExistsDialog(GameScene.this, "SaveSlot1");
                dialog.dismiss();
            });
        }
        Button dialogBtn_slot_2 = dialog.findViewById(R.id.slot2);
        if (slot2.equals("Empty")) {
            dialogBtn_slot_2.setBackgroundColor(Color.rgb(153, 153, 153));
            dialogBtn_slot_2.setTextColor(Color.rgb(51, 51, 51));
            dialogBtn_slot_2.setOnClickListener(view -> {
                Saves saves = new Saves();
                saves.setSaveSlot1(slot1);
                saves.setSaveSlot3(slot3);
                saves.setSaveSlot2(story.currentPosition);
                if (sp1.getBoolean("IsLoggedIn", false)) saveToDatabase(saves);
                Ed.putString("SaveSlot2", story.currentPosition);
                Ed.apply();
                Toast.makeText(GameScene.this, R.string.save_2_saved_successfully, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            });
        } else {
            dialogBtn_slot_2.setOnClickListener(view -> {
                showSaveExistsDialog(GameScene.this, "SaveSlot2");
                dialog.dismiss();
            });

        }
        Button dialogBtn_slot_3 = dialog.findViewById(R.id.slot3);
        if (slot3.equals("Empty")) {
            dialogBtn_slot_3.setBackgroundColor(Color.rgb(153, 153, 153));
            dialogBtn_slot_3.setTextColor(Color.rgb(51, 51, 51));
            dialogBtn_slot_3.setOnClickListener(view -> {
                Saves saves = new Saves();
                saves.setSaveSlot1(slot1);
                saves.setSaveSlot2(slot2);
                saves.setSaveSlot3(story.currentPosition);
                if (sp1.getBoolean("IsLoggedIn", false)) saveToDatabase(saves);
                Ed.putString("SaveSlot3", story.currentPosition);
                Ed.apply();
                Toast.makeText(GameScene.this, R.string.save_3_saved_successfully, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            });
        } else {
            dialogBtn_slot_3.setOnClickListener(view -> {
                showSaveExistsDialog(GameScene.this, "SaveSlot3");
                dialog.dismiss();
            });
        }
        dialog.show();
    }


    public void saveToDatabase(Saves saves) {
        DocumentReference documentReference;
        documentReference = Utilities.getDocumentReference();
        Map<String, Object> save = new HashMap<>();
        save.put("SaveSlot1", saves.getSaveSlot1());
        save.put("SaveSlot2", saves.getSaveSlot2());
        save.put("SaveSlot3", saves.getSaveSlot3());

        documentReference.update(save).addOnCompleteListener(task -> {
            if (!task.isSuccessful()) {
                Toast.makeText(GameScene.this, "Not saved in database. " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void showMenuDialog(Activity activity) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.menu_dialogbox_otp);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button dialogBtn_continue = dialog.findViewById(R.id.continue_button);
        dialogBtn_continue.setOnClickListener(v -> dialog.dismiss());
        Button dialogBtn_save = dialog.findViewById(R.id.save_button);
        dialogBtn_save.setOnClickListener(v -> {
            showSavesDialog(GameScene.this);
            dialog.dismiss();
        });
        Button dialogBtn_quit = dialog.findViewById(R.id.quit_button);
        dialogBtn_quit.setOnClickListener(v -> {
            startActivity(new Intent(GameScene.this, StartMenu.class));
            dialog.dismiss();
        });
        dialog.show();
    }

    public void showSaveExistsDialog(Activity activity, String Slot) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.slot_is_not_empty_dialog_otp);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button dialogBtn_save = dialog.findViewById(R.id.overwrite_btn);
        dialogBtn_save.setOnClickListener(v -> {
            Saves saves = new Saves();
            if (Objects.equals(Slot, "SaveSlot1")) {
                saves.setSaveSlot1(story.currentPosition);
            } else if (Objects.equals(Slot, "SaveSlot2")) {
                saves.setSaveSlot2(story.currentPosition);
            } else if (Objects.equals(Slot, "SaveSlot3")) {
                saves.setSaveSlot3(story.currentPosition);
            }
            SharedPreferences sp1 = getSharedPreferences("Login", MODE_PRIVATE);
            SharedPreferences sp = getSharedPreferences("Saves", MODE_PRIVATE);
            SharedPreferences.Editor Ed = sp.edit();
            if (sp1.getBoolean("IsLoggedIn", false)) saveToDatabase(saves);
            Ed.putString(Slot, story.currentPosition);
            Ed.apply();
            Toast.makeText(GameScene.this, "Saved successfully.", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });
        Button dialogBtn_quit = dialog.findViewById(R.id.cancel_btn);
        dialogBtn_quit.setOnClickListener(v -> dialog.dismiss());
        dialog.show();
    }

    @Override
    public void onBackPressed() {

    }

    public void mainMenu() {
        startActivity(new Intent(GameScene.this, StartMenu.class));
    }

    public void saveEndings() {
        SharedPreferences sp = getSharedPreferences("Endings", MODE_PRIVATE);
        SharedPreferences sp1 = getSharedPreferences("Login", MODE_PRIVATE);
        SharedPreferences.Editor Ed = sp.edit();
        Ed.putBoolean("Mine", HallOfFame.isMineAchieved);
        Ed.putBoolean("Hero", HallOfFame.isHeroAchieved);
        Ed.putBoolean("Camp infiltration", HallOfFame.isCampInfiltrationAchieved);
        Ed.putBoolean("Treasure", HallOfFame.isTreasureAchieved);
        Ed.putBoolean("Interception", HallOfFame.isInterceptionAchieved);
        Ed.putBoolean("Coming soon", HallOfFame.isComingSoonAchieved);
        Ed.apply();
        if (sp1.getBoolean("IsLoggedIn", false)) {
            Map<String, Object> Endings = new HashMap<>();
            Endings.put("Mine", HallOfFame.isMineAchieved);
            Endings.put("Hero", HallOfFame.isHeroAchieved);
            Endings.put("Camp infiltration", HallOfFame.isCampInfiltrationAchieved);
            Endings.put("Treasure", HallOfFame.isTreasureAchieved);
            Endings.put("Interception", HallOfFame.isInterceptionAchieved);
            Endings.put("Coming soon", HallOfFame.isComingSoonAchieved);
            DocumentReference DocRef = Utilities.getDocumentReferenceForEndings();
            DocRef.update(Endings);
        }
    }
}