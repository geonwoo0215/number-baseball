package numberbaseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class PlayerInputProcessor {

    private LinkedList<Integer> playerInput = new LinkedList<>();
    private final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public void getPlayerInput() throws IOException {
        char[] input = bf.readLine().toCharArray();
    }


}
