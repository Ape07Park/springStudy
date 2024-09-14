package com.example.springStudy.a1Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Configuration // @Configuration도 빈임
@ComponentScan() // 빈값으로 두면 자기 현재 페키지 스캔, 특정 페키지를 넣으면 그 페키지를 스캔함
public class DepInjectionLauncherApplication {

    /*
    main 함수
     */
    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)) {

            Arrays.stream(context.getBeanDefinitionNames()).forEach((System.out::println));

            DataService dataService = context.getBean(DataService.class);
            BusinessCalculationService businessCalculationService = context.getBean(BusinessCalculationService.class);

           int [] arr = dataService.retrieveData();
           System.out.println(Arrays.toString(arr));
            System.out.println(businessCalculationService.findMax());
        }
    }
}

/**
 * @Component: 인스턴스를 스프링이 관리
 * @ComponentScan(): 어느 페키지를 스캔해야 하는지 알림
 * DI: 빈과 그것들의 그것들의 의존성들을 찾고 연결. 원래는 사람이 객체 생성하고 그에 필요한 의존성을 넣어야 하지만 스프링이 그것을 함(제어)으로 인해 IOC(제어의 역전)라고 함
 * Autowiring: 스프링이 특정 빈에 대한 의존성(생성자)이 무엇인지 판별해 의존성(생성자)을 자동으로 넣어줌
 * @Component: 권장됨, 모든 자바 클래스에 사용 O, autoWiring의 방법은 필드, 세터, 생성자 주입의 방식이 가능함, @componentScan으로 어떤 걸 자동으로 주입할지 결정 O,
 * @Bean: spring Configuration의 메소드에 사용, autoWiring의 방법은 메소드 호출 혹은 페소드의 파라미터들 주입 O, @Bean 작성 필요, 빈 생성전 비즈니스 로직이 많거나 서드파티 라이브러리(ex 스프링 시큐리티)에 대한 빈을 인스턴스화할 경우
 */

/**
 * @Component: 권장됨, 모든 자바 클래스에 사용 O, autoWiring의 방법은 필드, 세터, 생성자 주입의 방식이 가능함, @componentScan으로 어떤 걸 자동으로 주입할지 결정 O,
 * @Bean: spring Configuration의 메소드에 사용, autoWiring의 방법은 메소드 호출 혹은 페소드의 파라미터들 주입 O, @Bean 작성 필요, 빈 생성전 비즈니스 로직이 많거나 서드파티 라이브러리(ex 스프링 시큐리티)에 대한 빈을 인스턴스화할 경우
 */
