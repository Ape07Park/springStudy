package com.example.springStudy.helloWorld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


// record: 사용자 정의 클래스를 만들 때 getter 등이 필요. record는  getter, setter, 생성자, toString 자동 생성으로 자바 빈을 만드는 것 더 간결화해줌.
 record Person(String name, int age, Address address) {
}

record Address(String firstLine, String state, String city, String zip) {
}

/**
 * 스프링 컨테이너(스프링 컨텍스트): 스프링 빈과 수명주기 관리
 * 스프링 컨테이너의 인풋: POJOs, Config
 * 스프링 컨테이너의 아웃풋: ready system
 */

/**
 * 설정 클래스(Config)
 * 설정 클래스 내부에서 메서드를 정의해 스프링 빈 생성, 빈에 대한 것을 관리, 스프링 컨테니어를 만들기 위한 인풋
 *
 */
@Configuration
public class HelloWorldConfiguration {
    /**
     * 스프링 빈 정의(관리) 영역
     * 스프링 빈: 스프링에서 관리하는 것들을 의미함.
     */

    @Bean // 스프링 컨테이너가 관리하는 빈을 생산함을 나타냄
    public String name() {
        return "Park";
    }

    @Bean // 스프링 컨테이너가 관리하는 빈을 생산함을 나타냄
    public int age() {
        return 15;
    }

    /**
     * 이름으로 빈 호출하기
     */
    @Bean
    public Person person() {
        var person = new Person("Park", 25, new Address("korea", "경기", "의왕", "16666"));
        return person;
    }

    // 같은 기능을 가진 다른 이름의 메서드 호출
    @Bean
    public Person person2Method() {
        return new Person(name(), age(), address());
    }

    /**
     * 내가 지정한 이름으로 호출하기
     * 빈의 이름을 메서드의 이름이 아닌 내가 지정한 이름으로 사용할 시 name=~~ 를 사용함
     */
    @Bean(name = "address2")
    @Primary // ~~.class로 부를 때 or Address라는 빈을 사용할 때 기본적(우선적)으로 사용하는 것임을 명시
    public Address address() {
        return new Address("korea", "경기", "의왕", "16666");
    }

    /**
     * 각 빈을 특정 메서드의 파라미터로 받기.
     * 각 빈을 특정 메서드의 파라미터로 받아서 그 특정 메서드를 호출하면 파라미터의 빈들도 호출됨
     */
    @Bean
    public Person person3Parameters(String name, int age, Address address2) {
        return new Person(name, age, address2);
    }

    @Bean
    @Primary
    public Person person4Parameters(String name, int age, Address address) {
        return new Person(name, age, address);
    }

    @Bean(name = "address3")
    @Qualifier("address3Qualifier") // @Primary로 지정한 빈 말고 같은 클래스를 리턴하는 다른 빈을 사용하고 싶을 때 사용
    public Address address3() {
        return new Address("US", "DC", "ciatle", "22222");
    }

    @Bean
    public Person person5Qualifier(String name, int age,  @Qualifier("address3Qualifier") Address address) { // address3Qualifier 사용법
        return new Person(name, age, address);
    }
}
