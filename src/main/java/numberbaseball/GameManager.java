package numberbaseball;

import java.io.IOException;

public class GameManager {

    private final MessageManager messageManager = new MessageManager();
    private final RandomNumberMaker randomNumberMaker = new RandomNumberMaker();
    private final NumberComparer numberComparer = new NumberComparer();
    private final PlayerInputProcessor playerInputProcessor = new PlayerInputProcessor();


    public void gameStart() throws IOException {

        do {
            gameSet();
            gamePlay();
        } while (gameRetry());

    }

    private void gameSet() {
        randomNumberMaker.makeRandomNumber();
        numberComparer.setRandomNumber(randomNumberMaker.getRandomNumber());
    }

    private void gamePlay() throws IOException {
        while (true) {
            gameInput();
            gameCompare();

            if (numberComparer.isThreeStrike()) {
                messageManager.correct();
                break;
            }

        }
    }

    private void gameCompare() {
        numberComparer.judge();
        messageManager.inputResponse(numberComparer.getBall(), numberComparer.getStrike());
    }

    private void gameInput() throws IOException {
        while (true) {
            messageManager.inputRequest();
            if (playerInputProcessor.validateInput(messageManager.getInput())){
                numberComparer.setPlayerInput(playerInputProcessor.getPlayerInput());
                break;
            }
            messageManager.wrongRequest();
        }
    }

    private boolean gameRetry() throws IOException {
        while(true){
            messageManager.retryRequest();
            if(playerInputProcessor.validateAnswerInput(messageManager.getInput()))break;
            messageManager.wrongRequest();
        }
        return playerInputProcessor.getRetryInput().equals("1");

    }


}
