package com.example.springStudy;

import com.example.springStudy.game.GameRunner;
import com.example.springStudy.game.MarioGame;

public class AppGamingBasicJava {
    public static void main(String[] args) {

        /**
         * 강한 결합
         */
        var marioGame = new MarioGame();
        var gameRunner = new GameRunner(marioGame);
        gameRunner.run();

    }
}
