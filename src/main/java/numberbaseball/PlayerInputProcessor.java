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
    private final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    private List<Integer> playerInput = new LinkedList<>();
    private String input;

    public void getPlayerInput() throws IOException {
        input = bf.readLine();
    }

    public boolean isNumber() {
       try{
           Integer.parseInt(input);
       }catch (Exception e){
           return false;
       }
       return true;
    }

    public void toIntegerList(){
        playerInput = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }




}
