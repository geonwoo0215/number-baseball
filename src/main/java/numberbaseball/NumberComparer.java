package numberbaseball;
import java.util.LinkedList;
import java.util.List;

public class NumberComparer {

    private List<Integer> randomNumber = new LinkedList<>();
    private List<Integer> playerInput = new LinkedList<>();

    private int strike;
    private int ball;

    public void setRandomNumber(List<Integer> randomNumber) {
        this.randomNumber = randomNumber;
    }

    public void setPlayerInput(List<Integer> playerInput) {
        this.playerInput = playerInput;
    }

    public void judge(){
        isStrike();
        isBall();
    }

    public boolean isThreeStrike(){
        return this.strike == 3;
    }

    private void isStrike(){
        strike = 0;
        for(int i : playerInput){
            if(randomNumber.contains(i)&&playerInput.indexOf(i)==randomNumber.indexOf(i)){
                strike++;
            }
        }
    }

    private void isBall(){
        ball = 0;
        for(int i : playerInput){
            if(randomNumber.contains(i)&&playerInput.indexOf(i)!=randomNumber.indexOf(i)){
                ball++;
            }
        }
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
