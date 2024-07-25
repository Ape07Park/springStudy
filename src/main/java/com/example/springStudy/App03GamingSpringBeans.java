package com.example.springStudy;

import com.example.springStudy.game.GameRunner;
import com.example.springStudy.game.GamingConsole;
import com.example.springStudy.game.MarioGame;
import com.example.springStudy.game.PackmamGame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingSpringBeans {
    public static void main(String[] args) {

       try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GamingConfig.class)) {

           context.getBean(GamingConsole.class).up();

          PackmamGame packmamGame = context.getBean(PackmamGame.class);

          // 의존성-packmamGame-이 주입 == autowiring
           GameRunner gameRunner = context.getBean(GameRunner.class);

           gameRunner.run();
       }
    }
}
