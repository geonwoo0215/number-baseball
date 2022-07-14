package numberbaseball;

import java.util.LinkedList;

public class RandomNumberMaker {

    private final int NUMBER_DIGIT = 3;

    private LinkedList<Integer> randomNumber = new LinkedList<>();

    public void makeRandomNumber(){
        while(randomNumber.size()<NUMBER_DIGIT){
            int num = getSingleDigit();
            if(!randomNumber.contains(num)) randomNumber.add(num);
        }
    }

    private int getSingleDigit() {
        return (int) (Math.random() * 9 + 1);
    }


}
