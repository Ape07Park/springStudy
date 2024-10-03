package com.example.springStudy.f1;

import jakarta.annotation.PostConstruct;
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
}

@Component
class SomeDependency{
    @PostConstruct // 스프링은 자동으로 의존성을 연결하고 의존성 주입이 이루어지자 마자  @PostConstruct를 지닌 메소드를 실행 ex) db에서 데이터 가져와 초기화 할려고 할 때
    // 초기화 수행을 위해 의존성 주입이 완료된 후에 실행되어야 하는 메소드에 사용하며 이 메소드는 클래스를 사용하기 전에 호출되야 하며 다른 빈이 이 빈을 사용할 수 있게 되기 전에 호출 됨
//    다른 리소스에서 호출되지 않아도 수행된다.
//      생성자가 호출되었을 때, 빈은 초기화되지 않았음(의존성 주입이 이루어지지 않았음)

//이럴 때 @PostConstruct를 사용하면 의존성 주입이 끝나고 실행됨이 보장되므로 빈의 초기화에 대해서 걱정할 필요가 없다.
//
//2) bean 의 생애주기에서 오직 한 번만 수행된다는 것을 보장한다. (어플리케이션이 실행될 때 한번만 실행됨)
//
//따라서 bean이 여러 번 초기화되는 걸 방지할 수 있다.
    // bean 초기화가 완료된 뒤 수행됨이 보장
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
