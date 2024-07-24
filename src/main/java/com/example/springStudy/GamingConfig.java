package com.example.springStudy;


import com.example.springStudy.game.GameRunner;
import com.example.springStudy.game.GamingConsole;
import com.example.springStudy.game.MarioGame;
import com.example.springStudy.game.PackmamGame;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GamingConfig {

    @Bean(name = "pacman")
    public GamingConsole gaming() {
        var game = new PackmamGame();
        return game;
    }

//    @Bean(name = "mario")
//    public GamingConsole gaming2() {
//        var game = new MarioGame();
//        return game;
//    }

    /**
     * new GameRunner()에 넣을 것
     * 1. 메서드 채로 가져오기 ex) new GameRunner(gaming())
     * 2. game을 매개 변수로 전달하기 ex)  public GameRunner gameRunner(GamingConsole game)
     *
     */
     @Bean
    public GameRunner gameRunner(GamingConsole game) {
        var gameRunner = new GameRunner(game);
        return gameRunner;
     }

}
