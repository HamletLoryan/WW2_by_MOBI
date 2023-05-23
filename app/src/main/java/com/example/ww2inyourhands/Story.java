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
            case "Start Point": startPoint(); break;
            case "The Mission starts": theMissionStarts(); break;

        }

    }

private void showAllButtons(){
    gs.variantABtn.setVisibility(View.VISIBLE);
    gs.variantBBtn.setVisibility(View.VISIBLE);
    gs.variantCBtn.setVisibility(View.VISIBLE);
    gs.variantCBtn.setVisibility(View.VISIBLE);

}

    public void startPoint(){

        gs.sceneImage.setImageResource(R.drawable.usa_flag);
        gs.sceneText.setText(R.string.startPoint);


        gs.variantABtn.setVisibility(View.INVISIBLE);
        gs.variantBBtn.setVisibility(View.INVISIBLE);
        gs.variantCBtn.setVisibility(View.INVISIBLE);
        gs.variantDBtn.setText(R.string.startPointBtnD);

        nextPositionA = null;
        nextPositionB = null;
        nextPositionC = null;
        nextPositionD = "Commander";

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
        nextPositionD = "The Mission starts";

        currentPosition = "Commander";
    }

    public void theMissionStarts(){
        gs.sceneImage.setImageResource(R.drawable.author_speech);
        gs.sceneText.setText(R.string.theMissionStartsText);

        showAllButtons();

        gs.variantABtn.setText(R.string.theMissionStartsBtnA);
        gs.variantBBtn.setText(R.string.theMissionStartsBtnB);
        gs.variantCBtn.setText(R.string.theMissionStartsBtnC);
        gs.variantDBtn.setText(R.string.theMissionStartsBtnD);

        nextPositionA = "Stealth";
        nextPositionB = "Vantage point";
        nextPositionC = "Information";
        nextPositionD = "Camp";

        currentPosition = "The Mission starts";
    }




}
