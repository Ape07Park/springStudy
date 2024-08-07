package com.example.springStudy.a1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class YourBusinessClass {
    Dependency1 dependency1;
    Dependency2 dependency2;

    public String toString(){
        return "Using" + dependency1 + " " + dependency2;
    }
}

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
