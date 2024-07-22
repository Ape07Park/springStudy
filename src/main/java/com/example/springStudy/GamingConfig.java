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

    @Bean(name = "mario")
    public GamingConsole gaming2() {
        var game = new MarioGame();
        return game;
    }

    @Bean
    public GameRunner gameRunner() {
        return new GameRunner(gaming());
    }


}
