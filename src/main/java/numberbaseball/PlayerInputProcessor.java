package numberbaseball;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerInputProcessor {

    private final int NUMBER_DIGIT = 3;

    private List<Integer> playerInput = new LinkedList<>();
    private String retryInput;

    public boolean validateInput(String input) {

        try{
            isNumber(input);
            toIntegerList(input);
            isNotOverlap();
            isThreeDigit();
        } catch(Exception e){
            return false;
        }
        return true;
    }

    public String getRetryInput() {
        return retryInput;
    }

    public List<Integer> getPlayerInput() {
        return playerInput;
    }

    public boolean validateAnswerInput(String retryInput){

        try {
            isNumber(retryInput);
            isOneOrTwo(retryInput);
        } catch (Exception e){
            return false;
        }
        this.retryInput = retryInput;
        return true;

    }

    private void isOneOrTwo(String input){
        if (!input.equals("1") && !input.equals("2")) {
            throw new RuntimeException();
        }
    }

    private void isNumber(String input) {
       try{
           Integer.parseInt(input);
       }catch (Exception e){
           throw new RuntimeException();
       }
    }

    private void toIntegerList(String input){
        playerInput = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void isNotOverlap(){
        if(playerInput.stream().distinct().count()!= NUMBER_DIGIT){
            throw new RuntimeException();
        }
    }

    private void isThreeDigit(){
        if(playerInput.stream().count()!=NUMBER_DIGIT){
            throw new RuntimeException();
        }
    }

}
