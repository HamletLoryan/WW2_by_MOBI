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
            case "Stealth": stealth(); break;
            case "Vantage point": vantagePoint(); break;
            case "Locals": locals(); break;
            case "Camp": camp(); break;

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
        nextPositionC = "Locals";
        nextPositionD = "Camp";

        currentPosition = "The Mission starts";
    }

    public void stealth(){
        gs.sceneImage.setImageResource(R.drawable.forest);
        gs.sceneText.setText(R.string.stealth);

        gs.variantABtn.setText(R.string.stealthBtnA);
        gs.variantBBtn.setText(R.string.stealthBtnB);
        gs.variantCBtn.setText(R.string.stealthBtnC);
        gs.variantDBtn.setText(R.string.stealthBtnD);

        nextPositionA = "Observation";
        nextPositionB = "Camp infiltration";
        nextPositionC = "Circling around";
        nextPositionD = "Retreat from forest";

        currentPosition = "Stealth";
    }
    public void vantagePoint(){
        gs.sceneImage.setImageResource(R.drawable.binoculars);
        gs.sceneText.setText(R.string.vantagePoint);

        gs.variantABtn.setText(R.string.vantagePointBtnA);
        gs.variantBBtn.setText(R.string.vantagePointBtnB);
        gs.variantCBtn.setText(R.string.vantagePointBtnC);
        gs.variantDBtn.setText(R.string.vantagePointBtnD);

        nextPositionA = "Observe from hiding";
        nextPositionB = "Interception";
        nextPositionC = "Binoculars";
        nextPositionD = "Report";

        currentPosition = "Vantage point";
    }
    public void locals(){
        gs.sceneImage.setImageResource(R.drawable.village);
        gs.sceneText.setText(R.string.locals);

        gs.variantABtn.setText(R.string.localsBtnA);
        gs.variantBBtn.setText(R.string.localsBtnB);
        gs.variantCBtn.setText(R.string.localsBtnC);
        gs.variantDBtn.setText(R.string.localsBtnD);

        nextPositionA = "Marketplace";
        nextPositionB = "Observation point";
        nextPositionC = "Villager";
        nextPositionD = "Eavesdrop";

        currentPosition = "Locals";
    }
    public void camp(){
        gs.sceneImage.setImageResource(R.drawable.forest_camp);
        gs.sceneText.setText(R.string.camp);

        gs.variantABtn.setText(R.string.campBtnA);
        gs.variantBBtn.setText(R.string.campBtnB);
        gs.variantCBtn.setText(R.string.campBtnC);
        gs.variantDBtn.setText(R.string.campBtnD);

        nextPositionA = "Enemy targets";
        nextPositionB = "Supply";
        nextPositionC = "Setting defend.";
        nextPositionD = "Preparation";

        currentPosition = "Camp";
    }






}
