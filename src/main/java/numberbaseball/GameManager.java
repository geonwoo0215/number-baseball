package numberbaseball;

import java.io.IOException;

public class GameManager {

    private MessageManger messageManger = new MessageManger();
    private RandomNumberMaker randomNumberMaker = new RandomNumberMaker();
    private NumberComparer numberComparer = new NumberComparer();
    private PlayerInputProcessor playerInputProcessor = new PlayerInputProcessor();


    public void gameStart() throws IOException {

        do {
            randomNumberMaker.makeRandomNumber();
            numberComparer.setRandomNumber(randomNumberMaker.getRandomNumber());
            gamePlay();
        } while (gameRetry());

    }

    private void gamePlay() throws IOException {
        while (true) {
            gameInput();
            gameCompare();

            if (numberComparer.isThreeStrike()) {
                messageManger.correct();
                break;
            }

        }
    }

    private void gameCompare() {
        numberComparer.setPlayerInput(playerInputProcessor.getPlayerInput());
        numberComparer.judge();
        messageManger.inputResponse(numberComparer.getBall(), numberComparer.getStrike());
    }

    private void gameInput() throws IOException {
        while (true) {
            messageManger.inputRequest();
            messageManger.setInputValid(playerInputProcessor.validateInput(messageManger.getInput()));
            if (messageManger.isInputValid()) break;
            messageManger.wrongRequest();
        }
    }

    private boolean gameRetry() throws IOException {
        while(true){
            messageManger.retryRequest();
            messageManger.setAnswerValid(playerInputProcessor.validateAnswerInput(messageManger.getInput()));
            if(messageManger.isAnswerValid())break;
            messageManger.wrongRequest();
        }
        if(playerInputProcessor.getRetryInput().equals("1")){
            return true;
        }
        return false;

    }


}
