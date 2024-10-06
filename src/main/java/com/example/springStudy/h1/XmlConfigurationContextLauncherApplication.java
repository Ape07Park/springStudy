package com.example.springStudy.h1;

import com.example.springStudy.game.GameRunner;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class XmlConfigurationContextLauncherApplication {


    /*
    main 함수
     */
    public static void main(String[] args) {
        // /resources/contextConfiguration.xml을 가져와 contextConfiguration.xml에서 설정한 것을 설정한 것의 내용으로 삼아서 스프링 컨테이너를 작동시키는 것이다.
        try (var context = new ClassPathXmlApplicationContext("contextConfiguration.xml")) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach((System.out::println));

            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("pacmanGame"));
            System.out.println(context.getBean("gameRunner"));

            var gameRunner = context.getBean(GameRunner.class);

            gameRunner.run();

        }
    }
}
