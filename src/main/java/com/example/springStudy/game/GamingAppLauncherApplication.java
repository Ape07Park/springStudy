package com.example.springStudy.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.springStudy.game") // game 폴더를 스캔하도록 지시
public class GamingAppLauncherApplication {


    /**
     * @Component이 붙어 있는 곳이 어딘지 몰라 GamingConsole game 주입 실패. 따라서 @Component이 붙어 있는 곳 위치 알려야 함.
     * 그 역할을 하는 것이 @ComponentScan
      */

//    @Bean
//    public GameRunner gameRunner(GamingConsole game) { // 스프링이 @Component를 달은 pacmanGame의 인스턴스를 자동으로 생성해 GamingConsole로 autoWiring함
//        System.out.println("param" + game);
//        var gameRunner = new GameRunner(game);
//        return gameRunner;
//    }

    // @Primary: 우선권 주기 여러 개의 자격이 있는 후보가 있을 떄
    // @Qualifier: 특정 빈을 지정해 autoWiring함
    // ** @Primary, @Qualifier를 선택할 때 항상 특정 의존성을 사용하는 클래스의 관점에서 생각할 것
    // **   @Qualifier가 @Primary보다 더 높은 우선순위 지님
    // @Autowired: 어떤 거든 상관 없으면 @Autowired 사용

    /*
    main 함수
     */
    public static void main(String[] args) {

       try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)) {

           context.getBean(GamingConsole.class).up();

          // 의존성-packmamGame- 인스턴스가 스프링에서 자동으로 생성되어 주입 == autowiring
           GameRunner gameRunner = context.getBean(GameRunner.class);

           gameRunner.run();
       }
    }
}
