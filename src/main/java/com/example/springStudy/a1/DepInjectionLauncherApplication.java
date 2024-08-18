package com.example.springStudy.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class YourBusinessClass {
    /**
     * 의존성 주입의 유형들
     * 1. 생성자: 게임 클래스를 볼 것
     * 2. 필드
     * 3. setter
     *  @Autowired : 스프링에게 자동으로 의존성을 주입해달라는 표시
     */

    /**
     * 1. 생성자를 이용한 주입 : 개발자는 의존성을 정의하고 생성자를 이용해 의존성을 주입하기만 하면 됨
     */
//    @Autowired
    // YourBusinessClass의 의존성으로 dependency1, dependency2가 이미 존재하기에 @Autowired가 없어도 스프링이 자동으로 Autowired 해줌.
    public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        System.out.println("To use Constructor");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    /**
     * 스프링 공식 문서는 생성자 방식을 추천함. 이유는 모든 초기화가 1개의 메소드에서 발생하기 때문
     */

    /**
     * 2. 필드를 이용한 주입
     */
//    @Autowired : 스프링에게 자동으로 의존성을 주입해달라는 표시
    Dependency1 dependency1;

//    @Autowired
    Dependency2 dependency2;

    /**
     * 3. setter를 통한 의존성 주입
     */
//    @Autowired
//    public void setDependency1(Dependency1 dependency1) {
//        this.dependency1 = dependency1;
//    }
//
//    @Autowired
//    public void setDependency2(Dependency2 dependency2) {
//        System.out.println("setter1");
//        this.dependency2 = dependency2;
//    }

    public String toString(){
        return "Using " + dependency1 + " " + dependency2;
    }
}

/**
 * 의존성 정의
 */
@Component
class Dependency1{

}

@Component
class Dependency2{

}

@Configuration // @Configuration도 빈임
@ComponentScan() // 빈값으로 두면 자기 현재 페키지 스캔
public class DepInjectionLauncherApplication {

    /*
    main 함수
     */
    public static void main(String[] args) {

       try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)) {
           Arrays.stream(context.getBeanDefinitionNames()).forEach((System.out::println));

           // 빈의 이름보단 유형(.class)을 사용하는 것이 좋음
           System.out.println(context.getBean(YourBusinessClass.class));

       }
    }
}
