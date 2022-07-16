package numberbaseball;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        GameManager gameManager = new GameManager();
        gameManager.gameStart();
    }
}
