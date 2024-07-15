package com.example.springStudy.game;

public class GameRunner {
   MarioGame game;

   public GameRunner(MarioGame game) {
       this.game = game;
   }

    // sout 대신 logging을 쓸 것
    public void run() {
        System.out.println("Running Game" + game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
