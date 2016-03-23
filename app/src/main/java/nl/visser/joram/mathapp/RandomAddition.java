package nl.visser.joram.mathapp;

import android.util.Log;

/**
 * Created by Joram on 21-3-2016.
 */
public class RandomAddition {

    private static final String LOG_TAG = "RandomAddition"; //The log tag can only be 23 characters long.

    //Set difficulty via this constructor.
    public RandomAddition(int difficulty) {
        int numberOfDigits = 1;
        if (difficulty == 1) {
            numberOfDigits = 9;
        } else if (difficulty == 2) {
            numberOfDigits = 99;
        } else if (difficulty == 3) {
            numberOfDigits = 999;
        }
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
        setFirstNumber((int)(Math.random()*numberOfDigits)+1);
        setSecondNumber((int)(Math.random()*numberOfDigits)+1);
    }

    public String getString() {
        String returnString = Integer.toString(getFirstNumber()) + " + " + Integer.toString(getSecondNumber()) + " = ";
        Log.d(LOG_TAG, "The returnString: " + returnString);
        return returnString;
    }

    public int getInt() {
        int returnInt = getFirstNumber() + getSecondNumber();
        Log.d(LOG_TAG, "The returnInt: " + Integer.toString(returnInt));
        return returnInt;
    }
}
