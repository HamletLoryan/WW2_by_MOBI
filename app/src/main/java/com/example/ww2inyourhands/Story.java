package com.example.ww2inyourhands;

public class Story {

    GameScene gs;

    public Story(GameScene gs){

        this.gs = gs;
    }

    public void startPoint(){

        gs.sceneText.setText("");
    }
}
