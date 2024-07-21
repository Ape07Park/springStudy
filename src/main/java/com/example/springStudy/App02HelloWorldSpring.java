package com.example.springStudy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App02HelloWorldSpring {
    public static void main(String[] args) {

        /**
         * 스프링 컨테이너(스프링 컨텍스트, IOC-제어의 역전- 컨테이너): 스프링 빈과 수명주기 관리
         * 스프링 컨테이너의 인풋: POJOs, Config
         * 스프링 컨테이너의 아웃풋: ready system
         * 자바 클래스를 만들고 설정을 만들면 IOC 컨테이너가 런타임 시스템을 만듦
         * 그 만들어진 런타임 시스템이 spring 컨텍스트를 만들고 모든 빈 관리
         */

        /**
         * 스프링 컨테이너의 두 구성요소
         * 1. bean Factory: 기본 스프링 컨테이너, 거의 사용 X
         * 2. application context: 엔터프라이즈 전용이 있는 고급 스프링 컨테이너로 웹 어플 만들거나 국제화 기능이 필요한 경우 그리고 스프링 AOP와 통합할 때 사용
         * 웹 어플을 만드는 경우가 많으므로 application context를 가장 자주 사용. 웹 어플, 웹 서비스, restAPI, 마이크로서비스에서 사용
         */

        /**
         * POJO(Plain Old Java Object)
         * 순수하게 오래된 자바 객체
         * 모든 자바 객체는 POJO
         * HelloWorldConfiguration에서 만든 모든 빈은 POJO
         */

        /**
         * Java Bean
         * 1. no-arg constructor
         * 2. getter, setter
         * 3. serializable 인터페이스 구현
         * 위의 3가지를 지키면 그 클래스의 인스턴스는 Java Bean이 된다.
         */

        /**
         * Spring Bean
         * Spring에서 관리하는 모든 것이 Spring Bean
         * Spring에서 관리하는 모든 자바 객체
         * spring context, spring에서 만든 bean
         * IOC 컨테이너가 관리하는 모든 객체는 Spring Bean
         */




        /**
         * 스프링이 대신 객체를 생성하고 결합하도록 함
         * **JVM 내부에 스프링 컨텍스트 생성
         */

        /**
         * 1. 스프링 컨텍스트 시작
         * spring context 설정 파일: 이 설정 파일을 이용해 스프링 컨텍스트 실행
         */
        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

//      2. 스프링이 관리하게 할 것 설정(지정)
//      1) 설정 클래스 만들기
//      @Configuration : 설정 클래스 만들고 이름 등을 정의


//      3. 스프링에 의해 관리되는 빈 가져오기
        // 스프링(스프링 컨텍스트)이 관리하는 것은 무엇이든 bean임
        // 1) 컨텍스트에서 값을 가져오는 방법 중 1가지는 이름으로 가져오는 것 ex) 메서드 명
        System.out.println(context.getBean("name")); // 스프링이 관리 중이라 스프링 컨텍스트를 실행해 컨텍스트 안의 특정 빈을 가져오기 O

        System.out.println(context.getBean("age"));

        System.out.println(context.getBean("person"));

        System.out.println(context.getBean("person2Method")); // 같은 기능을 가진 다른 이름의 메서드 호출

//      2) 빈의 이름을 메서드가 아닌 내가 지정한 이름으로 불러오기
        System.out.println(context.getBean("address2"));

//      3) 빈의 클래스를 가지고 와 값 가져오기
        System.out.println(context.getBean(Address.class)); // 검색하고 있는 것이 빈의 유형(Address)이라 같은 유형이 두 개 이상이면 에러남. @Primary 사용할 것

        System.out.println(context.getBean(Person.class)); // @Primary로 지정한 빈 말고 같은 종류의 다른 빈을 사용

        // 4) 각 빈을 특정 메서드의 파라미터로 받기
        System.out.println(context.getBean("person3Parameters")); // 같은 기능을 가진 다른 이름의 메서드 호출

        // 5) spring이 관리하는 bean 나열하기, helloWorldConfiguration도 빈임
        Arrays.stream( context.getBeanDefinitionNames()).forEach(System.out::println); // Return the names of all beans defined in this factory

//        6) @Primary로 Person 빈을 사용할 때 기본적으로 사용하는 빈임을 명시함
        System.out.println(context.getBean(Person.class));

//        7) Address3에 Qualifier를 달아 @Primary로 지정한 빈 말고 같은 종류의 다른 빈을 사용
        System.out.println(context.getBean("person5Qualifier"));

    }
}
