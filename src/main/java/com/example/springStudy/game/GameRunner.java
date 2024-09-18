package com.example.springStudy.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
public class GameRunner {

  private GamingConsole game;

    // 여기서 생성자 주입이 일어남.
   public GameRunner(@Qualifier("superContra") GamingConsole game) {
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
