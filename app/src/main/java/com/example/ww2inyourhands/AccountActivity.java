package com.example.ww2inyourhands;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class AccountActivity extends AppCompatActivity {

    TextView emailTextView;
    Button logOutButton;
    ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sp=getSharedPreferences("Login", MODE_PRIVATE);
        String email = sp.getString("Email", "Email not found.");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        emailTextView = findViewById(R.id.email);
        logOutButton = findViewById(R.id.log_out_btn);
        progressBar = findViewById(R.id.progress_bar);
        emailTextView.setText(email);
        logOutButton.setOnClickListener(v -> showDialog(AccountActivity.this));
    }
    private void showDialog(Activity activity) {

        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.log_out_dialog_otp);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button dialogBtn_continue = dialog.findViewById(R.id.cancel_btn);
        dialogBtn_continue.setOnClickListener(v -> dialog.dismiss());
        Button dialogBtn_log_in = dialog.findViewById(R.id.log_out_btn);
        dialogBtn_log_in.setOnClickListener(v -> {
            logOutButton.setVisibility(INVISIBLE);
            progressBar.setVisibility(VISIBLE);
            SharedPreferences sp1 =getSharedPreferences("Login", MODE_PRIVATE);
            SharedPreferences.Editor Ed= sp1.edit();
            Ed.putBoolean("IsLoggedIn", false);
            Ed.putString("Email",null );
            Ed.putString("Password",null);
            Ed.apply();
            Toast.makeText(AccountActivity.this, R.string.logged_out_successfully, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(AccountActivity.this, StartMenu.class));
            LoginActivity.loggedIn = false;
            finish();
        });
        dialog.show();
    }





}