package nl.visser.joram.mathapp.CalculationModule;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public boolean calculateWhetherAnswerIsTrue(Sum sum, MathAppNumber number) {

        int answer = calculateValueOfSum(sum);
        Log.d("Answer calculation" , "" + answer);

        if (answer == number.getValueOf()) {
            return true;
        } else {
            return false;
        }
    }

    private int calculateValueOfSum(Sum sum) {
        List<MathAppNumber> numbers = sum.getNumbersOfSum();
        List<Integer> valueOfMathApp = new ArrayList<>();

        for (MathAppNumber number: numbers) {
            valueOfMathApp.add(number.getValueOf());
        }

        List<Operator> operators = sum.getOperatorsOfSum();

        return calculateValue(valueOfMathApp, operators);
    }

    private int calculateValue(List<Integer> numbers, List<Operator> operators) {

        int valueOfSum = 0;

        while(!operators.isEmpty() && operators.contains(Operator.TIMES)) {
            int timesOperatorIndex = operators.indexOf(Operator.TIMES);

            valueOfSum = numbers.get(timesOperatorIndex) * numbers.get(timesOperatorIndex+ 1);
            numbers.remove(timesOperatorIndex + 1);
            numbers.remove(timesOperatorIndex);
            numbers.add(timesOperatorIndex, valueOfSum);
            operators.remove(timesOperatorIndex);
        }

        while(!operators.isEmpty() && operators.contains(Operator.DIVIDEDBY)) {
            int dividedOperatorIndex = operators.indexOf(Operator.DIVIDEDBY);

            valueOfSum = numbers.get(dividedOperatorIndex) / numbers.get(dividedOperatorIndex+ 1);
            numbers.remove(dividedOperatorIndex + 1);
            numbers.remove(dividedOperatorIndex);
            numbers.add(dividedOperatorIndex, valueOfSum);
            operators.remove(dividedOperatorIndex);
        }

        while(!operators.isEmpty() && operators.contains(Operator.MINUS)) {
            int minusOperatorIndex = operators.indexOf(Operator.MINUS);

            valueOfSum = numbers.get(minusOperatorIndex) - numbers.get(minusOperatorIndex+ 1);
            numbers.remove(minusOperatorIndex + 1);
            numbers.remove(minusOperatorIndex);
            numbers.add(minusOperatorIndex, valueOfSum);
            operators.remove(minusOperatorIndex);
        }

        while(!operators.isEmpty() && operators.contains(Operator.PLUS)) {
            int plusOperatorIndex = operators.indexOf(Operator.PLUS);

            valueOfSum = numbers.get(plusOperatorIndex) + numbers.get(plusOperatorIndex+ 1);
            numbers.remove(plusOperatorIndex + 1);
            numbers.remove(plusOperatorIndex);
            numbers.add(plusOperatorIndex, valueOfSum);
            operators.remove(plusOperatorIndex);
        }

        return valueOfSum;
    }
}






