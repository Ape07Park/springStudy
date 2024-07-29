package com.example.springStudy.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // 동일한 클래스에 Component가 있는 경우 우선적으로 autowiring함
public class MarioGame implements GamingConsole{
    public void up() {
        System.out.println("jump");
    }

    public void down() {
        System.out.println("down");
    }

    public void left() {
        System.out.println("go back");
    }

    public void right() {
        System.out.println("jump");
    }

}
