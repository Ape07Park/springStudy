package com.example.springStudy.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
public class GameRunner {

  private GamingConsole game;

    /**
     * MarioGame등 과 강하게 결합되어 있어 superContraGame을 실행시키기 위해선
     * 새로운 코드 작성 필요 즉 버전 및 종류 등에 따라 코드를 일일이 수정해야 함 - 강한 결합
     * 결합: 무언가를 변경할 떄 얼마나 많은 작업이 포함되어 있는가에 대한 것임
     * 강한 결합은 상황에 따라 많은 것을 수정해야하기에 느슨한 결합을 추구해야 한다.
     * 프로그래밍에선 코드를 작게 변경하면서 기능을 변경할 수 있어야 함
     * 느슨한 결합은 인터페이스와 스프링을 이용해 구현할 수 있음
     */


    /**
     * 인터페이스(GamingConsole)를 도입해 GameRunner가 특정 게임에 종속(결합)되는 것이 아님
     *  인터페이스와만 결합되어 있음
     *  인터페이스를 만들어 그 인터페이스를 각 게임이 구현하게 만들어 필요한 기능을 갖추도록 함
     *  특정 게임에 따라 GameRunner 클래스는 변경 x
     */

    // 여기서 생성자 주입이 일어남.
   public GameRunner(@Qualifier("superContra") GamingConsole game) {
       this.game = game;
   }

    // sout 대신 logging을 쓸 것
    public void run() {
        System.out.println("Running Game" + game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
