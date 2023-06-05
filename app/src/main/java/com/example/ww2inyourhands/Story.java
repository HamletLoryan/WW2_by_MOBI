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
            case "Hero": hero(); break;
            case "Treasure": treasure(); break;
            case "Interception": interception();break;
            case "Mine": mine(); break;
            case "Coming soon": comingSoon(); break;
            case "Observation": observation(); break;
            case "Camp infiltration": campInfiltration(); break;
            case "Circling around": circlingAround(); break;

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
        nextPositionD = "Mine";

        currentPosition = "Stealth";
    }
    public void vantagePoint(){
        gs.sceneImage.setImageResource(R.drawable.binoculars);
        gs.sceneText.setText(R.string.vantagePoint);

        gs.variantABtn.setText(R.string.vantagePointBtnA);
        gs.variantBBtn.setText(R.string.vantagePointBtnB);
        gs.variantCBtn.setText(R.string.vantagePointBtnC);
        gs.variantDBtn.setText(R.string.vantagePointBtnD);

        nextPositionA = "Treasure";
        nextPositionB = "Interception";
        nextPositionC = "Observation";
        nextPositionD = "Mine";

        currentPosition = "Vantage point";
    }
    public void locals(){
        gs.sceneImage.setImageResource(R.drawable.village);
        gs.sceneText.setText(R.string.locals);

        gs.variantABtn.setText(R.string.localsBtnA);
        gs.variantBBtn.setText(R.string.localsBtnB);
        gs.variantCBtn.setText(R.string.localsBtnC);
        gs.variantDBtn.setText(R.string.localsBtnD);

        nextPositionA = "Coming soon";
        nextPositionB = "Coming soon";
        nextPositionC = "Coming soon";
        nextPositionD = "Coming soon";

        currentPosition = "Locals";
    }
    public void camp(){
        gs.sceneImage.setImageResource(R.drawable.forest_camp);
        gs.sceneText.setText(R.string.camp);

        gs.variantABtn.setText(R.string.campBtnA);
        gs.variantBBtn.setText(R.string.campBtnB);
        gs.variantCBtn.setText(R.string.campBtnC);
        gs.variantDBtn.setText(R.string.campBtnD);

        nextPositionA = "Coming soon";
        nextPositionB = "Coming soon";
        nextPositionC = "Coming soon";
        nextPositionD = "Coming soon";

        currentPosition = "Camp";
    }


    public void observation(){
        gs.sceneImage.setImageResource(R.drawable.binoculars);
        gs.sceneText.setText(R.string.during_the_observation_you_found_out_that_the_enemy_keeps_some_british_soldiers_as_captives_what_do_you_do);

        gs.variantABtn.setText(R.string.try_to_circle_the_enemies_around);
        gs.variantBBtn.setText(R.string.retreat_from_the_forest_and_try_to_find_another_way);
        gs.variantCBtn.setText(R.string.infiltrate_the_enemy_camp);
        gs.variantDBtn.setText(R.string.get_closer_and_get_more_information);

        nextPositionA = "Circling around";
        nextPositionB = "Mine";
        nextPositionC = "Camp infiltration";
        nextPositionD = "Mine";

        currentPosition = "Observation";
    }
    public void campInfiltration(){
        gs.sceneImage.setImageResource(R.drawable.medal);
        gs.sceneText.setText(R.string.infiltration_text);

        gs.variantABtn.setVisibility(View.INVISIBLE);
        gs.variantBBtn.setVisibility(View.INVISIBLE);
        gs.variantCBtn.setVisibility(View.INVISIBLE);
        gs.variantDBtn.setText(R.string.back_to_main_menu);
        gs.menuBtn.setVisibility(View.INVISIBLE);
        gs.variantDBtn.setOnClickListener(v -> gs.mainMenu());

        HallOfFame.isCampInfiltrationAchieved = true;

        gs.saveEndings();

        currentPosition = "Camp infiltration";
    }
    public void circlingAround(){
        gs.sceneImage.setImageResource(R.drawable.annexation);
        gs.sceneText.setText(R.string.circling_around_text);

        gs.variantABtn.setText(R.string.get_back_home);
        gs.variantBBtn.setText(R.string.give_a_hand_of_help_to_british);
        gs.variantCBtn.setText(R.string.go_further_and_try_to_find_more_information_about_enemies);
        gs.variantDBtn.setText(R.string.find_something_to_eat);

        nextPositionA = "Hero";
        nextPositionB = "Mine";
        nextPositionC = "Mine";
        nextPositionD = "Mine";

        currentPosition = "Circling around";
    }

    public void mine(){
        gs.sceneImage.setImageResource(R.drawable.mine_explosion);
        gs.sceneText.setText(R.string.mine_text);

        gs.variantABtn.setVisibility(View.INVISIBLE);
        gs.variantBBtn.setVisibility(View.INVISIBLE);
        gs.variantCBtn.setVisibility(View.INVISIBLE);
        gs.variantDBtn.setText(R.string.back_to_main_menu);
        gs.menuBtn.setVisibility(View.INVISIBLE);
        gs.variantDBtn.setOnClickListener(v -> gs.mainMenu());

        HallOfFame.isMineAchieved = true;

        gs.saveEndings();

        currentPosition = "Mine";
    }
    public void hero(){
        gs.sceneImage.setImageResource(R.drawable.achievement);
        gs.sceneText.setText(R.string.hero);

        gs.variantABtn.setVisibility(View.INVISIBLE);
        gs.variantBBtn.setVisibility(View.INVISIBLE);
        gs.variantCBtn.setVisibility(View.INVISIBLE);
        gs.menuBtn.setVisibility(View.INVISIBLE);
        gs.variantDBtn.setText(R.string.back_to_main_menu);
        gs.variantDBtn.setOnClickListener(v -> gs.mainMenu());

        HallOfFame.isHeroAchieved = true;

        gs.saveEndings();

        currentPosition = "Hero";
    }

    public void treasure(){
        gs.sceneImage.setImageResource(R.drawable.open_treasure_chest);
        gs.sceneText.setText(R.string.treasure);

        gs.variantABtn.setVisibility(View.INVISIBLE);
        gs.variantBBtn.setVisibility(View.INVISIBLE);
        gs.variantCBtn.setVisibility(View.INVISIBLE);
        gs.menuBtn.setVisibility(View.INVISIBLE);
        gs.variantDBtn.setText(R.string.back_to_main_menu);
        gs.variantDBtn.setOnClickListener(v -> gs.mainMenu());

        HallOfFame.isTreasureAchieved = true;

        gs.saveEndings();

        currentPosition = "Treasure";

    }
    public void interception(){
        gs.sceneImage.setImageResource(R.drawable.hasty_grave);
        gs.sceneText.setText(R.string.interception);

        gs.variantABtn.setVisibility(View.INVISIBLE);
        gs.variantBBtn.setVisibility(View.INVISIBLE);
        gs.variantCBtn.setVisibility(View.INVISIBLE);
        gs.menuBtn.setVisibility(View.INVISIBLE);
        gs.variantDBtn.setText(R.string.back_to_main_menu);
        gs.variantDBtn.setOnClickListener(v -> gs.mainMenu());

        HallOfFame.isInterceptionAchieved = true;

        gs.saveEndings();

        currentPosition = "Interception";

    }

    public void comingSoon(){
        gs.sceneImage.setImageResource(R.drawable.coming_soon);
        gs.sceneText.setText(R.string.coming_soon);

        gs.variantABtn.setVisibility(View.INVISIBLE);
        gs.variantBBtn.setVisibility(View.INVISIBLE);
        gs.variantCBtn.setVisibility(View.INVISIBLE);
        gs.menuBtn.setVisibility(View.INVISIBLE);
        gs.variantDBtn.setText(R.string.back_to_main_menu);
        gs.variantDBtn.setOnClickListener(v -> gs.mainMenu());

        HallOfFame.isComingSoonAchieved = true;

        gs.saveEndings();

        currentPosition = "Coming soon";

    }







}
