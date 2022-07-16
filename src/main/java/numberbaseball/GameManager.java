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

            while (true) {

                while (true) {
                    messageManger.inputRequest();
                    messageManger.setInputValid(playerInputProcessor.validateInput(messageManger.getInput()));
                    if (messageManger.isInputValid()) break;
                    messageManger.wrongRequest();
                }

                numberComparer.setPlayerInput(playerInputProcessor.getPlayerInput());
                numberComparer.judge();
                messageManger.inputResponse(numberComparer.getBall(), numberComparer.getStrike());

                if (numberComparer.isThreeStrike()) break;

            }
        } while (gameRetry());



    }

    public boolean gameRetry() throws IOException {
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