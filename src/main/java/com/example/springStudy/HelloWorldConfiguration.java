package com.example.springStudy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



// record: 사용자 정의 클래스를 만들 때 getter 등이 필요. record는  getter, setter, 생성자, toString 자동 생성으로 자바 빈을 만드는 것 더 간결화해줌.
record Person (String name, int age) { }

record Address (String firstLine, String state,String city, String zip) { }
/**
 * 설정 클래스
 * 설정 클래스 내부에서 메서드를 정의해 스프링 빈 생성
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
    public String age() {
        return "15";
    }

    @Bean
    public Person person() {
        var person = new Person("Park", 25);
        return person;
    }

    @Bean
    public Address address() {
        return new Address("korea", "경기", "의왕", "16666");
    }
}
