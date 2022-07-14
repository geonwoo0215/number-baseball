package numberbaseball;
import java.util.LinkedList;
import java.util.List;

public class NumberComparer {

    private List<Integer> randomNumber = new LinkedList<>();
    private List<Integer> playerInput = new LinkedList<>();

    public void setRandomNumber(List<Integer> randomNumber) {
        this.randomNumber = randomNumber;
    }

    public void setPlayerInput(List<Integer> playerInput) {
        this.playerInput = playerInput;
    }
}
