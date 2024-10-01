package com.example.springStudy.e1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
// 싱글톤이 스프링에서 생생되는 빈의 기본값 - 빈을 요청할 때마다 매번 같은 인스턴스를 가져옴 - 같은 인스턴스 쓰고 싶을 때 사용
// 싱글톤은 스프링 컨테이너당 하나의 인스턴스만 있음, 서버가 클라이언트의 상태를 보존하지 않음

// GOF 자바 싱글톤: JVM 당 객체 인스턴스 1개
//@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON) or default
@Component
class NormalClass {

}

//프로토타입은 스프링 컨테이너당 여러 인스턴스 가능, 서버가 클라이언트의 상태를 보존할 필요가 있을 시 사용 ex) 사용자마다의 아이디 등
@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE) // 프로토타입은 빈을 요청할 때마다 매번 새로운 인스턴스를 생성해서 가져옴 - 다른 인스턴스 쓰고 싶을 때 사용
@Component
class PrototypeClass {

}

/**
 * Request 스코프: HTTP request 당 1개의 인스턴스
 * Session 스코프: 사용자 HTTP session 당 1개의 인스턴스
 * Application 스코프: 웹 어플리케이션 당 1개의 인스턴스
 * Websocket 스코프: 웹소켓 당 1개의 인스턴스
 *
 */

/*
지연 초기화와 즉시 초기화
 */
@Configuration // @Configuration도 빈임
@ComponentScan() // 빈값으로 두면 자기 현재 페키지 스캔, 특정 페키지를 넣으면 그 페키지를 스캔함
public class BeanScopesLauncherApplication {

    /*
    main 함수
     */
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanScopesLauncherApplication.class)) {


            System.out.println("normalClass start");
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));

            System.out.println("PrototypeClass start");
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));




        }
    }
}

