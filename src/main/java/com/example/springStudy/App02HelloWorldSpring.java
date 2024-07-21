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
        // 1) 컨텍스트에서 값을 가져오는 방법 중 1가지는 이름으로 가져오는 것 ex) 메서드 명
        System.out.println(context.getBean("name")); // 스프링이 관리 중이라 스프링 컨텍스트를 실행해 컨텍스트 안의 특정 빈을 가져오기 O

        System.out.println(context.getBean("age"));

        System.out.println(context.getBean("person"));

        System.out.println(context.getBean("person2Method")); // 같은 기능을 가진 다른 이름의 메서드 호출

//      2) 빈의 이름을 메서드가 아닌 내가 지정한 이름으로 불러오기
        System.out.println(context.getBean("address2"));

//      3) 빈의 클래스를 가지고 와 값 가져오기
//        System.out.println(context.getBean(Address.class)); // 검색하고 있는 것이 빈의 유형(Address)이라 같은 유형이 두 개 이상이면 에러남

        // 4) 각 빈을 특정 메서드의 파라미터로 받기
        System.out.println(context.getBean("person3Parameters")); // 같은 기능을 가진 다른 이름의 메서드 호출
    }
}
