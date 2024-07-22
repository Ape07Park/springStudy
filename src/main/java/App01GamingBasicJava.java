import com.example.springStudy.game.GameRunner;
import com.example.springStudy.game.MarioGame;
import com.example.springStudy.game.PackmamGame;

public class App01GamingBasicJava {
    public static void main(String[] args) {

        /**
         * 강한 결합
         */
        var game = new MarioGame();
//      var game = new SuperContraGame();
        PackmamGame packmamGame = new PackmamGame();
        var gameRunner = new GameRunner(packmamGame); // 객체 생성 및 의존성 연결
//        gameRunner의 의존성은 게임들-gameConsole을 구현한-임. 이유는 게임이 없으면 gameRunner 실행 x라서

        /**
         * 스프링이 대신 객체를 생성하고 결합하도록 함
         */

        /**
         * JVM 내부에 스프링 컨텍스트 생성
         */


        gameRunner.run();

    }
}
