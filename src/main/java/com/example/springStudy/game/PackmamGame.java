package com.example.springStudy.game;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component // 스프링 컨텍스트에서 관리 따라서 spring이 자동으로 인스턴스 생성해줌, 개발자가 직접 작성한 Class를 Bean으로 등록하기 위한 어노테이션
@ComponentScan // @Component이 붙어 있는 곳 위치 알리는 역할
public class PackmamGame implements GamingConsole{
    @Override
    public void up() {
        System.out.println("pac up");
    }

    @Override
    public void down() {
        System.out.println("pac down");
    }

    @Override
    public void left() {
        System.out.println("pac left");
    }

    @Override
    public void right() {
        System.out.println("pac right");
    }
}
