package com.example.springStudy.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {}

// @Component으로 인해 자동으로 초기화 됨
@Component
@Lazy // 지연 초기화: 초기화가 즉시(시작할 떄)가 아닌 사용할 때 초기화 발생, @Component나 @Bean에만 사용 가능함 - ClassB를 사용할 때 초기화가 된다
// 즉시 초기화 추천. 이유는 실행 즉시 에러를 바로 알 수 있어서
    // 지연 초기화 방법: @Lazy or @Lazy(value = true) -> 에러 발생 시 runtimeError로 나옴
    // 즉시 초기화 방법: @Lazy(value = false) or (Absence of @Lazy) ->  에러 발생 시 어플 실행 중지
class ClassB {
    private ClassA classA;
    // Logic
    public ClassB(ClassA classA) {
        System.out.println("Some initialization logic");
        this.classA = classA;
    }

    public void doSomething(){
        System.out.println("do something");
    }
}

/*
지연 초기화와 즉시 초기화
 */
@Configuration
@ComponentScan()
public class LazyInitializeLauncherApplication {

    /*
    main 함수
     */
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LazyInitializeLauncherApplication.class)) {

            System.out.println("Initialization");
            context.getBean(ClassB.class).doSomething();
        }
    }
}

