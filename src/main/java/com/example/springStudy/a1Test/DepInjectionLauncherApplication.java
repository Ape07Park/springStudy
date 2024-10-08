package com.example.springStudy.a1Test;

import org.springframework.beans.factory.annotation.Qualifier;
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

            int[] arr = dataService.retrieveData(); // MongoDB의 것이 주입되는 이유는 @Primary가 MongoDB이기 때문이다.
            System.out.println(Arrays.toString(arr));
            System.out.println(businessCalculationService.findMax()); // 여기는 Mysql의 데이터가 들어가는데 그 이유는 BusinessCalculationService의 의존성인 DataService를 mysql로 설정해서다.
        }
    }
}



