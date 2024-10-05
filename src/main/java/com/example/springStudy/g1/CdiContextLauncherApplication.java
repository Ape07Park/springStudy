package com.example.springStudy.g1;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * CDI의 어노테이션이 스프링의 어노테이션과 같은 기능을 하는 것들을 볼 수 있음. 단지 이름만 다르다
 * 스프링의 어노테이션은 이 CDI를 구현해 사용하므로 스프링에선 CDI도 사용 가능하다
 */
//@Component
@Named
class BusinessService {
  private DataService dataService;

    public DataService getDataService() {
        System.out.println("Setter Injection2");
        return dataService;
    }
//    @Autowired
    @Inject
    public void setDataService(DataService dataService) {
        System.out.println("Setter Injection1");
        this.dataService = dataService;
    }
}

//@Component
@Named
class DataService {

}

@Configuration // @Configuration도 빈임
@ComponentScan() // game 폴더를 스캔하도록 지시
public class CdiContextLauncherApplication {


    /*
    main 함수
     */
    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CdiContextLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach((System.out::println));

            System.out.println(context.getBean(BusinessService.class)
                    .getDataService());


        }
    }
}
