package numberbaseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerInputProcessor {

    private final int NUMBER_DIGIT = 3;

    private List<Integer> playerInput = new LinkedList<>();



    public void validateNumber(String input) {

        isNumber(input);
        toIntegerList(input);
        isNotOverlap();
        isThreeDigit();

    }

    public void validateAnswerNumber(String input){
        isNumber(input);
        isOneOrTwo(input);
    }

    public void isOneOrTwo(String input){
        if (!input.equals("1") && !input.equals("2")) {
            throw new RuntimeException();
        }
    }

    public void isNumber(String input) {
       try{
           Integer.parseInt(input);
       }catch (Exception e){
           throw new RuntimeException();
       }
    }

    public void toIntegerList(String input){
        playerInput = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void isNotOverlap(){
        if(playerInput.stream().distinct().count()!= NUMBER_DIGIT){
            throw new RuntimeException();
        }
    }

    public void isThreeDigit(){
        if(playerInput.stream().count()!=NUMBER_DIGIT){
            throw new RuntimeException();
        }
    }

}
