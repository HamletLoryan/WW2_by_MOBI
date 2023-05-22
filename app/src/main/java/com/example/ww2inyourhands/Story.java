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
            case "Commander": commander(); break;
            case "Author Speech 1": authorSpeech1(); break;
            case "Kitchen": kitchen(); break;
            case "Start Point": startPoint(); break;

        }

    }



    public void startPoint(){

        gs.sceneImage.setImageResource(R.drawable.usa_flag);
        gs.sceneText.setText(R.string.startPoint);


        gs.variantABtn.setVisibility(View.INVISIBLE);
        gs.variantBBtn.setVisibility(View.INVISIBLE);
        gs.variantCBtn.setText(R.string.startPointBtnC);
        gs.variantDBtn.setText(R.string.startPointBtnD);

        nextPositionA = null;
        nextPositionB = null;
        nextPositionC = "Commander";
        nextPositionD = "Kitchen";

        currentPosition = "Start Point";


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
        nextPositionD = "Author Speech 1";

        currentPosition = "Commander";
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
        nextPositionD = "Barrack";

        currentPosition = "Author Speech 1";
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
        nextPositionD = "Commander";

        currentPosition = "Kitchen";
    }
}
