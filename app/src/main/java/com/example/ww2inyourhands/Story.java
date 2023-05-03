package com.example.ww2inyourhands;

import android.content.Context;
import android.view.View;

public class Story {

    GameScene gs;

    String nextPositionA, nextPositionB, nextPositionC, nextPositionD, currentPosition;

    public Story(GameScene gs){

        this.gs = gs;
    }

    public void setPosition(String position){
        switch (position){
            case "commander": commander(); break;
            case "authorSpeech1": authorSpeech1(); break;
            case "kitchen": kitchen(); break;

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
        gs.sceneText.setText("1943. You are a private soldier in USA army. You will get your mission objectives from Commander. He is waiting for you near the aircraft.");

        gs.variantABtn.setVisibility(View.INVISIBLE);
        gs.variantBBtn.setVisibility(View.INVISIBLE);
        gs.variantCBtn.setText("Go to aircraft");
        gs.variantDBtn.setText("Go to kitchen to eat something");

        nextPositionA = null;
        nextPositionB = null;
        nextPositionC = "commander";
        nextPositionD = "kitchen";

        currentPosition = "startPoint";


    }

    public void commander(){

        gs.sceneImage.setImageResource(R.drawable.commander);
        gs.sceneText.setText("Private. Your mission is to parachute down behind enemies front line,find the division Delta, and get them back home.  ");

        gs.variantABtn.setVisibility(View.INVISIBLE);
        gs.variantBBtn.setVisibility(View.INVISIBLE);
        gs.variantCBtn.setVisibility(View.INVISIBLE);
        gs.variantDBtn.setText("YES SIR!");

        nextPositionA = null;
        nextPositionB = null;
        nextPositionC = null;
        nextPositionD = "authorSpeech1";

        currentPosition = "commander";
    }
    public void authorSpeech1(){

        gs.sceneImage.setImageResource(R.drawable.author_speech);
        gs.sceneText.setText("Now, you have your objective, you can prepare your inventory and then go to bar, may be for the last time.");

        gs.variantABtn.setVisibility(View.INVISIBLE);
        gs.variantBBtn.setVisibility(View.INVISIBLE);
        gs.variantCBtn.setVisibility(View.INVISIBLE);
        gs.variantDBtn.setText("Go to barrack");

        nextPositionA = null;
        nextPositionB = null;
        nextPositionC = null;
        nextPositionD = "barrack";

        currentPosition = "authorSpeech1";
    }
    public void kitchen(){

        gs.sceneImage.setImageResource(R.drawable.commander);
        gs.sceneText.setText("Commander: Hey, private! What are you doing? Come here .");

        gs.variantABtn.setVisibility(View.INVISIBLE);
        gs.variantBBtn.setVisibility(View.INVISIBLE);
        gs.variantCBtn.setVisibility(View.INVISIBLE);
        gs.variantDBtn.setText("Go back to Commander");

        nextPositionA = null;
        nextPositionB = null;
        nextPositionC = null;
        nextPositionD = "commander";

        currentPosition = "kitchen";
    }
}
