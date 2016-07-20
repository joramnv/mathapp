package nl.visser.joram.mathapp;

import android.util.Log;

import java.util.Random;

/**
 * Created by Joram on 21-3-2016.
 */
public class RandomNumberGenerator {

    private static final String LOG_TAG = RandomNumberGenerator.class.getSimpleName();

    //Set difficulty via this constructor.
    public RandomNumberGenerator(int difficulty) {
        int numberOfDigits = 1;
        if (difficulty == 1) {
            numberOfDigits = 10;
        } else if (difficulty == 2) {
            numberOfDigits = 100;
        } else if (difficulty == 3) {
            numberOfDigits = 1000;
        }
        //TODO maybe this is not the place to perform the generate() method.
        generate(numberOfDigits);
    }

    private int firstNumber;
    private int secondNumber;

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void generate(int numberOfDigits) {
        Random random = new Random();
        setFirstNumber(random.nextInt(numberOfDigits)+1);
        setSecondNumber(random.nextInt(numberOfDigits)+1);
    }

    public int getAdditionEquals() {
        int equals = getFirstNumber() + getSecondNumber();
        Log.v(LOG_TAG, "Equals: " + Integer.toString(equals));
        return equals;
    }

    public int getSubtractionEquals() {
        int equals = getFirstNumber() - getSecondNumber();
        Log.v(LOG_TAG, "Equals: " + Integer.toString(equals));
        return equals;
    }

    public int getMultiplicationEquals() {
        int equals = getFirstNumber() * getSecondNumber();
        Log.v(LOG_TAG, "Equals: " + Integer.toString(equals));
        return equals;
    }

    public int getDivisionEquals() {
        int equals = getFirstNumber() / getSecondNumber();
        Log.v(LOG_TAG, "Equals: " + Integer.toString(equals));
        return equals;
    }
}
