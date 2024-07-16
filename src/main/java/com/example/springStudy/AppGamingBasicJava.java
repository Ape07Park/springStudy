package com.example.springStudy;

import com.example.springStudy.game.GameRunner;
import com.example.springStudy.game.MarioGame;
import com.example.springStudy.game.PackmamGame;
import com.example.springStudy.game.SuperContraGame;

public class AppGamingBasicJava {
    public static void main(String[] args) {

        /**
         * 강한 결합
         */
      var game = new MarioGame();
//      var game = new SuperContraGame();
        PackmamGame packmamGame = new PackmamGame();
        var gameRunner = new GameRunner(packmamGame);
        gameRunner.run();

    }
}
