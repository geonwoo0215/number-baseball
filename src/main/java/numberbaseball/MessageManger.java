package numberbaseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MessageManger {

    private final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private final String ANSWER_MESSAGE = "3개의 숫자를 모두 맞혔습니다.! 게임 종료";
    private final String RETRY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private PlayerInputProcessor playerInputProcessor = new PlayerInputProcessor();


    private void inputRequest() throws IOException {

        try{
            System.out.println(INPUT_MESSAGE);
            String playerInput = bf.readLine();
            playerInputProcessor.validateNumber(playerInput);
        } catch (Exception e){
            inputRequest();
        }

    }




}