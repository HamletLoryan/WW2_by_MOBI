package com.example.ww2inyourhands;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameScene extends AppCompatActivity {

    Story story = new Story(this);

    ImageView sceneImage;
    TextView sceneText;
    Button variantABtn, variantBBtn, variantCBtn, variantDBtn;

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

        variantABtn.setTransformationMethod(null);
        variantBBtn.setTransformationMethod(null);
        variantCBtn.setTransformationMethod(null);
        variantDBtn.setTransformationMethod(null);

        variantABtn.setOnClickListener(v-> varA());
        variantBBtn.setOnClickListener(v-> varB());
        variantCBtn.setOnClickListener(v-> varC());
        variantDBtn.setOnClickListener(v-> varD());

        story.startPoint();
    }

    public void varA(){
        story.setPosition(story.nextPositionA);
    }
    public void varB(){
        story.setPosition(story.nextPositionB);
    }
    public void varC(){
        story.setPosition(story.nextPositionC);
    }
    public void varD(){
        story.setPosition(story.nextPositionD);
    }
}