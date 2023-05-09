package com.example.ww2inyourhands;
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

//    public void showAllButtons(){
//        gs.variantABtn.setVisibility(View.VISIBLE);
//        gs.variantBBtn.setVisibility(View.VISIBLE);
//        gs.variantABtn.setVisibility(View.VISIBLE);
//        gs.variantBBtn.setVisibility(View.VISIBLE);
//    }


    public void startPoint(){

        gs.sceneImage.setImageResource(R.drawable.usa_flag);
        gs.sceneText.setText(R.string.startPoint);


        gs.variantABtn.setVisibility(View.INVISIBLE);
        gs.variantBBtn.setVisibility(View.INVISIBLE);
        gs.variantCBtn.setText(R.string.startPointBtnD);
        gs.variantDBtn.setText(R.string.startPointBtnD);

        nextPositionA = null;
        nextPositionB = null;
        nextPositionC = "commander";
        nextPositionD = "kitchen";

        currentPosition = "startPoint";


    }

    public void commander(){

        gs.sceneImage.setImageResource(R.drawable.commander);
        gs.sceneText.setText(R.string.commander);

        gs.variantABtn.setVisibility(View.INVISIBLE);
        gs.variantBBtn.setVisibility(View.INVISIBLE);
        gs.variantCBtn.setVisibility(View.INVISIBLE);
        gs.variantDBtn.setText(R.string.commanderBtnD);

        nextPositionA = null;
        nextPositionB = null;
        nextPositionC = null;
        nextPositionD = "authorSpeech1";

        currentPosition = "commander";
    }
    public void authorSpeech1(){

        gs.sceneImage.setImageResource(R.drawable.author_speech);
        gs.sceneText.setText(R.string.authorSpeech1);

        gs.variantABtn.setVisibility(View.INVISIBLE);
        gs.variantBBtn.setVisibility(View.INVISIBLE);
        gs.variantCBtn.setVisibility(View.INVISIBLE);
        gs.variantDBtn.setText(R.string.authorSpeech1BtnD);

        nextPositionA = null;
        nextPositionB = null;
        nextPositionC = null;
        nextPositionD = "barrack";

        currentPosition = "authorSpeech1";
    }
    public void kitchen(){

        gs.sceneImage.setImageResource(R.drawable.commander);
        gs.sceneText.setText(R.string.kitchen);

        gs.variantABtn.setVisibility(View.INVISIBLE);
        gs.variantBBtn.setVisibility(View.INVISIBLE);
        gs.variantCBtn.setVisibility(View.INVISIBLE);
        gs.variantDBtn.setText(R.string.kitchenBtnD);

        nextPositionA = null;
        nextPositionB = null;
        nextPositionC = null;
        nextPositionD = "commander";

        currentPosition = "kitchen";
    }
}
