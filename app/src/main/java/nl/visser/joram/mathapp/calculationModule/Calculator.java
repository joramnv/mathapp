package nl.visser.joram.mathapp.calculationModule;

import java.util.List;

public class Calculator {

    public boolean calculateSumEqualsUserInputNumber(Sum sum, MathAppNumber userInputNumber) {
        List<MathAppNumber> numbers = sum.getNumbersOfSum();
        List<Operator> operators = sum.getOperatorsOfSum();
        int valueOfSum = numbers.get(0).getValueOf();
        for(int i = 0; i< operators.size(); i++) {
            valueOfSum = calculatePartialSum(operators.get(i), valueOfSum, numbers.get(i+1).getValueOf());
        }
        return valueOfSum == userInputNumber.getValueOf();
    }

    private int calculatePartialSum(Operator operator, int valueOfSum, int nextValue) {
        if(Operator.PLUS.equals(operator)) {
            valueOfSum += nextValue;
        } else if(Operator.MINUS.equals(operator)) {
            valueOfSum -= nextValue;
        } else if(Operator.TIMES.equals(operator)) {
            valueOfSum *= nextValue;
        } else if(Operator.DIVIDED_BY.equals(operator)) {
            valueOfSum /= nextValue;
        }
        return valueOfSum;
    }

}
