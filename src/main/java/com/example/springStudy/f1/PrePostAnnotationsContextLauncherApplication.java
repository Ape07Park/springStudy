package com.example.springStudy.f1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
class SomeClass {
    private SomeDependency dependency;

    public SomeClass(SomeDependency dependency) {
        super();
        this.dependency = dependency;
        System.out.println("All dependencies are ready");
    }
    public void initialize() {
        dependency.getReady();
    }

    @PreDestroy // 어플리케이션 종료 전 빈을 스프링 컨텍스트에서 제거 전에 뭔가 해야 할 때 사용 ex) close 등 으로 자원 반환 필요 시
    public void cleanUp() {
        System.out.println("cleanUp");
    }
}


@Component
class SomeDependency{
    @PostConstruct //  의존성 주입이 된 후 실행해야하는 메소드에 사용한다. 초기화 수행을 위해 의존성 주입이 완료된 후에 실행되어야 하는 메소드에 사용 ex) db에서 데이터 가져와 초기화 할려고 할 때

    // bean이 여러 번 초기화되는 걸 방지
//      생성자가 호출되었을 때, 빈은 초기화되지 않았음(의존성 주입이 이루어지지 않았음) 이럴 때 @PostConstruct를 사용하면 의존성 주입이 끝나고 실행됨이 보장되므로 빈의 초기화에 대해서 걱정할 필요가 없다.


    public void getReady() {
        System.out.println("Some logic initialization");
    }
}
@Configuration // @Configuration도 빈임
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {

    /*
    main 함수
     */
    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach((System.out::println));

        }
    }
}
