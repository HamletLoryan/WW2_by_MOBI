package com.example.ww2inyourhands;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    public static boolean loggedIn;

    EditText emailEditText, passwordEditText;
    Button logInButton, backButton;
    ProgressBar progressBar;
    TextView createAccountBtnTextView;

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.email_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        logInButton = findViewById(R.id.log_in_button);
        backButton = findViewById(R.id.back_btn);
        createAccountBtnTextView = findViewById(R.id.login_btn);
        firebaseAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progress_bar);
        backButton.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, StartMenu.class)));

        loggedIn = false;


        createAccountBtnTextView.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, CreateAccountActivity.class)));

        logInButton.setOnClickListener(v -> {
            String email, password;
            email = String.valueOf(emailEditText.getText());
            password = String.valueOf(passwordEditText.getText());

            if (TextUtils.isEmpty(email)) {
                emailEditText.setError("Please enter your email.");
                return;
            }
            if (TextUtils.isEmpty(password)) {
                passwordEditText.setError("Please enter your password.");
                return;
            }

            logInButton.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);

            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    if (Objects.requireNonNull(firebaseAuth.getCurrentUser()).isEmailVerified()) {
                        SharedPreferences sp = getSharedPreferences("Login", MODE_PRIVATE);
                        SharedPreferences.Editor Ed = sp.edit();
                        Ed.putBoolean("IsLoggedIn", true);
                        Ed.putString("Email", email);
                        Ed.putString("Password", password);
                        Ed.apply();

                        getSaves();

                        loggedIn = true;
                        Toast.makeText(LoginActivity.this, R.string.logged_in_successfully, Toast.LENGTH_SHORT).show();
                    } else {
                        logInButton.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(LoginActivity.this, R.string.verify_your_email, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    logInButton.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(LoginActivity.this, Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });
    }

    @Override
    public void onBackPressed() {
    }

    public void getSaves(){
        DocumentReference dr = Utilities.getDocumentReference();
        Saves saves = new Saves();
        SharedPreferences sharedPreferences = getSharedPreferences("Saves", MODE_PRIVATE);
        saves.setSaveSlot1(sharedPreferences.getString("SaveSlot1", null));
        saves.setSaveSlot2(sharedPreferences.getString("SaveSlot2", null));
        saves.setSaveSlot3(sharedPreferences.getString("SaveSlot3", null));
        dr.get().addOnSuccessListener(documentSnapshot -> {
            Saves dataBaseSave = documentSnapshot.toObject(Saves.class);
            assert dataBaseSave != null;

                if(areLocalSavesEmpty(saves.getSaveSlot1(), saves.getSaveSlot2(), saves.getSaveSlot3()) && !areOnlineSavesEmpty(dataBaseSave.getSaveSlot1(), dataBaseSave.getSaveSlot2() , dataBaseSave.getSaveSlot3())){
                    showDialogForExistingOnlineSaves(LoginActivity.this, dataBaseSave, saves);

                }
                else if(areOnlineSavesEmpty(dataBaseSave.getSaveSlot1(), dataBaseSave.getSaveSlot2() , dataBaseSave.getSaveSlot3())  && !areLocalSavesEmpty(saves.getSaveSlot1(), saves.getSaveSlot2(), saves.getSaveSlot3())) {
                    Map<String, Object> s = new HashMap<>();
                   s.put("SaveSlot1", sharedPreferences.getString("SaveSlot1", "Empty"));
                   s.put("SaveSlot2", sharedPreferences.getString("SaveSlot2", "Empty"));
                   s.put("SaveSlot3", sharedPreferences.getString("SaveSlot3", "Empty"));
                    dr.update(s);
                    startActivity(new Intent(LoginActivity.this, StartMenu.class));
                    finish();}
                else if (!areLocalSavesEmpty(saves.getSaveSlot1(), saves.getSaveSlot2(), saves.getSaveSlot3()) && !areOnlineSavesEmpty(dataBaseSave.getSaveSlot1(), dataBaseSave.getSaveSlot2() , dataBaseSave.getSaveSlot3())){
                    showDialogForExistingOnlineSaves(LoginActivity.this, dataBaseSave, saves);

                }
                else{
                    Map<String, Object> s = new HashMap<>();
                    s.put("SaveSlot1", dataBaseSave.getSaveSlot1());
                    s.put("SaveSlot2", dataBaseSave.getSaveSlot2());
                    s.put("SaveSlot3", dataBaseSave.getSaveSlot3());
                    dr.update(s);
                    startActivity(new Intent(LoginActivity.this, StartMenu.class));
                    finish();
                }


        });
    }

    public void showDialogForExistingOnlineSaves(Activity activity, Saves save, Saves saves){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.online_saves_exist_dialog_otp);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button dialogBtn_continue = dialog.findViewById(R.id.load_btn);
        dialogBtn_continue.setOnClickListener(v -> {
            SharedPreferences sharedPreferences = getSharedPreferences("Saves", MODE_PRIVATE);
            SharedPreferences.Editor Ed = sharedPreferences.edit();
            Ed.putString("SaveSlot1", save.getSaveSlot1() );
            Ed.putString("SaveSlot2", save.getSaveSlot2() );
            Ed.putString("SaveSlot3", save.getSaveSlot3() );
            Ed.apply();
            startActivity(new Intent(LoginActivity.this, StartMenu.class));
            finish();
            dialog.dismiss();
        });
        Button dialogBtn_save = dialog.findViewById(R.id.no_btn);
        dialogBtn_save.setOnClickListener(v -> {
            DocumentReference dr = Utilities.getDocumentReference();
            Map<String, Object> s = new HashMap<>();
            s.put("SaveSlot1", saves.getSaveSlot1());
            s.put("SaveSlot2", saves.getSaveSlot2());
            s.put("SaveSlot3", saves.getSaveSlot3());
            dr.update(s);
            startActivity(new Intent(LoginActivity.this, StartMenu.class));
            finish();
            dialog.dismiss();
        });
        dialog.show();
    }

    public boolean areLocalSavesEmpty(String s1, String s2, String s3){
        return (s1 == null && s2 == null && s3 == null);
    }
    public boolean areOnlineSavesEmpty(String dbs1, String dbs2, String dbs3){
        return (dbs1.equals("Empty") && dbs2.equals("Empty") && dbs3.equals("Empty"));
    }

}