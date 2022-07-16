package numberbaseball;

import java.util.LinkedList;

public class RandomNumberMaker {

    private final int NUMBER_DIGIT = 3;

    private LinkedList<Integer> randomNumber ;


    public void makeRandomNumber(){
        randomNumber = new LinkedList<>();
        while(randomNumber.size()<NUMBER_DIGIT){
            addRandomNumber(getSingleDigit());
        }
    }

    public LinkedList<Integer> getRandomNumber() {
        return randomNumber;
    }

    private void addRandomNumber(int num) {
        if(isNotExist(num)) randomNumber.add(num);
    }

    private boolean isNotExist(int num) {
        return !randomNumber.contains(num);
    }

    private int getSingleDigit() {
        return (int) (Math.random() * 9 + 1);
    }


}
