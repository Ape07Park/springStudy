package com.example.springStudy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
    public static void main(String[] args) {


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
        // 컨텍스트에서 값을 가져오는 방법 중 1가지는 이름으로 가져오는 것 ex) 메서드 명
        System.out.println(context.getBean("name")); // 스프링이 관리 중이라 스프링 컨텍스트를 실행해 컨텍스트 안의 특정 빈을 가져오기 O

    }
}
