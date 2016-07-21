package nl.visser.joram.mathapp;

import android.util.Log;

import java.util.List;

public class Calculator {

    public boolean calculateAnswerIsTrue(Sum sum, MathAppNumber number) {

        if(calculateValueOfSum(sum) == number.getValueOf()) {
            Log.d("blablablab", "waar");
            return true;

        } else {
            Log.d("blablablab", "niet waar");
            return false;
        }
    }

    private int calculateValueOfSum(Sum sum) {
        List<MathAppNumber> numbers = sum.getNumbersOfSum();
        List<Operator> operators = sum.getOperatorsOfSum();
        int valueOfSum = 0;

        for(int i = 0; i< operators.size(); i++) {
            valueOfSum = numbers.get(i).getValueOf();
            if(operators.get(i).equals(Operator.MINUS)) {
                valueOfSum -= numbers.get(i+1).getValueOf();
            } else if(operators.get(i).equals(Operator.PLUS)) {
                valueOfSum += numbers.get(i+1).getValueOf();
            }
        }
        return valueOfSum;
    }
}
