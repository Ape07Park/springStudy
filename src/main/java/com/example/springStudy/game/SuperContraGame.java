package com.example.springStudy.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("superContra")
public class SuperContraGame implements GamingConsole{
    public void up() {
        System.out.println("up");
    }

    public void down() {
        System.out.println("sit down");
    }

    public void left() {
        System.out.println("go back");
    }

    public void right() {
        System.out.println("shoot a bullet");
    }
}
