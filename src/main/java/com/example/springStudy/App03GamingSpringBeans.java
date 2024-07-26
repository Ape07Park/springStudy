package com.example.springStudy;

import com.example.springStudy.game.GameRunner;
import com.example.springStudy.game.GamingConsole;
import com.example.springStudy.game.MarioGame;
import com.example.springStudy.game.PackmamGame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App03GamingSpringBeans {


    /**
     * @Component이 붙어 있는 곳이 어딘지 몰라 GamingConsole game 주입 실패. 따라서 @Component이 붙어 있는 곳 위치 알려야 함.
     * 그 역할을 하는 것이 @ComponentScan
      */

    @Bean
    public GameRunner gameRunner(GamingConsole game) {
        var gameRunner = new GameRunner(game);
        return gameRunner;
    }

    /*
    main 함수
     */
    public static void main(String[] args) {

       try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App03GamingSpringBeans.class)) {

           context.getBean(GamingConsole.class).up();

          PackmamGame packmamGame = context.getBean(PackmamGame.class);

          // 의존성-packmamGame-이 주입 == autowiring
           GameRunner gameRunner = context.getBean(GameRunner.class);

           gameRunner.run();
       }
    }
}
