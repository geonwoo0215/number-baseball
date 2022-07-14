package numberbaseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class PlayerInputProcessor {

    private final int NUMBER_DIGIT = 3;
    private final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    private LinkedList<Integer> playerInput = new LinkedList<>();
    private char[] input = new char[NUMBER_DIGIT];


    public void getPlayerInput() throws IOException {
        input = bf.readLine().toCharArray();
    }

    public boolean isNumber() {
        for (char num : input){
            if(num<'0'||num>'9'){
                return false;
            }
        }
        return true;
    }


}
