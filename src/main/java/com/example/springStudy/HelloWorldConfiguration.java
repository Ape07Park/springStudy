package com.example.springStudy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

}
