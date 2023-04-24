package com.example.ww2inyourhands;

import android.view.View;

public class Story {

    GameScene gs;
    String nextPositionA, nextPositionB, nextPositionC, nextPositionD;

    public Story(GameScene gs){

        this.gs = gs;
    }

    public void setPosition(String position){
        switch (position){
            case "captainMiller": captainMiller(); break;

        }

    }

    public void showAllButtons(){
        gs.variantABtn.setVisibility(View.VISIBLE);
        gs.variantBBtn.setVisibility(View.VISIBLE);
        gs.variantABtn.setVisibility(View.VISIBLE);
        gs.variantBBtn.setVisibility(View.VISIBLE);
    }

    public void startPoint(){

        gs.sceneImage.setImageResource(R.drawable.usa_flag);
        gs.sceneText.setText("1941. You are a private soldier in USA army. You will get your mission objectives from Captain Miller. He is waiting for you near the aircraft.");

        gs.variantABtn.setVisibility(View.INVISIBLE);
        gs.variantBBtn.setVisibility(View.INVISIBLE);
        gs.variantCBtn.setText("Go to aircraft");
        gs.variantDBtn.setText("Go to kitchen to eat something");

        nextPositionA = null;
        nextPositionB = null;
        nextPositionC = "captainMiller";
        nextPositionD = "kitchen";
    }

    public void captainMiller(){

        gs.sceneImage.setImageResource(R.drawable.usa_flag);
        gs.sceneText.setText("1941. You are a private soldier in USA army. You will get your mission objectives from Captain Miller. He is waiting for you near the aircraft.");

        gs.variantABtn.setVisibility(View.INVISIBLE);
        gs.variantBBtn.setVisibility(View.INVISIBLE);
        gs.variantCBtn.setText("Go to ");
        gs.variantDBtn.setText("Go to ");

        nextPositionA = null;
        nextPositionB = null;
        nextPositionC = "captainMiller";
        nextPositionD = "kitchen";
    }
}
