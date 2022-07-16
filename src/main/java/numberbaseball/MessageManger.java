package numberbaseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MessageManger {

    private final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private final String ANSWER_MESSAGE = "3개의 숫자를 모두 맞혔습니다.! 게임 종료";
    private final String RETRY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final String WARNING_MESSAGE = "잘못된 입력입니다.";
    private final String BALL = "볼 ";
    private final String STRIKE = "스트라이크";
    private final String NOTHING = "낫싱";
    private boolean inputValid;
    private boolean answerValid;
    private BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private String input;

    public boolean isInputValid() {
        return inputValid;
    }

    public boolean isAnswerValid() {
        return answerValid;
    }

    public String getInput() {
        return input;
    }

    public void setInputValid(boolean inputValid) {
        this.inputValid = inputValid;
    }

    public void setAnswerValid(boolean answerValid) {
        this.answerValid = answerValid;
    }

    public void inputRequest() throws IOException {
        System.out.print(INPUT_MESSAGE);
        this.input = bf.readLine();
    }

    public void correct(){System.out.println(ANSWER_MESSAGE);}

    public void wrongRequest(){
        System.out.println(WARNING_MESSAGE);
    }

    public void retryRequest() throws IOException {
        System.out.println(RETRY_MESSAGE);
        this.input = bf.readLine();
    }

    public void inputResponse(int ball, int strike){
        StringBuilder sb = new StringBuilder();
        if(ball>0){
            sb.append(ball).append(BALL);
        }
        if(strike>0){
            sb.append(strike).append(STRIKE);
        }
        if(strike==0&&ball==0){
            sb.append(NOTHING);
        }
        System.out.println(sb);
    }

}