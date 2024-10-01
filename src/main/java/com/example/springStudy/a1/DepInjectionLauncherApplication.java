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
@ComponentScan() // 빈값으로 두면 자기 현재 페키지 스캔, 특정 페키지를 넣으면 그 페키지를 스캔함
public class DepInjectionLauncherApplication {

    /*
    main 함수
     */
    public static void main(String[] args) {
       try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)) {
           Arrays.stream(context.getBeanDefinitionNames()).forEach((System.out::println));

           // 빈의 이름보단 유형(.class)을 사용하는 것이 좋음
           // toString 메소드가 정의되어 있어서 그 메소드의 리턴값인 Using com.example.springStudy.a1.Dependency1@32b260fa com.example.springStudy.a1.Dependency2@581ac8a8라는 결과가 나옴
           System.out.println(context.getBean(YourBusinessClass.class));

       }
    }
}

/**
 * @Component: 인스턴스를 스프링이 관리
 * @ComponentScan(): 어느 페키지를 스캔해야 하는지 알림
 *  DI: 빈과 그것들의 그것들의 의존성들을 찾고 연결. 원래는 사람이 객체 생성하고 그에 필요한 의존성을 넣어야 하지만 스프링이 그것을 함(제어)으로 인해 IOC(제어의 역전)라고 함
 *  Autowiring: 스프링이 특정 빈에 대한 의존성(생성자)이 무엇인지 판별해 의존성(생성자)을 자동으로 넣어줌
 */

/**
 * @Component: 권장됨, 모든 자바 클래스에 사용 O, autoWiring의 방법은 필드, 세터, 생성자 주입의 방식이 가능함, @componentScan으로 어떤 걸 자동으로 주입할지 결정 O,
 * @Bean: spring Configuration의 메소드에 사용, autoWiring의 방법은 메소드 호출 혹은 페소드의 파라미터들 주입 O, @Bean 작성 필요, 빈 생성전 비즈니스 로직이 많거나 서드파티 라이브러리(ex 스프링 시큐리티)에 대한 빈을 인스턴스화할 경우
 */
