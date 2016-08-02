package nl.visser.joram.mathapp.CalculationModule;

import java.util.List;

public class Calculator {

    public boolean calculateAnswerIsTrue(Sum sum, MathAppNumber number) {

        if(calculateValueOfSum(sum) == number.getValueOf()) {
            return true;
        } else {
            return false;
        }
    }

    private int calculateValueOfSum(Sum sum) {
        List<MathAppNumber> numbers = sum.getNumbersOfSum();
        List<Operator> operators = sum.getOperatorsOfSum();
        int valueOfSum = 0;
        valueOfSum = numbers.get(0).getValueOf();
        for(int i = 0; i< operators.size(); i++) {
            if(operators.get(i).equals(Operator.MINUS)) {
                valueOfSum -= numbers.get(i+1).getValueOf();
            } else if(operators.get(i).equals(Operator.PLUS)) {
                valueOfSum += numbers.get(i+1).getValueOf();
            } else if(operators.get(i).equals(Operator.DIVIDEDBY)) {
                valueOfSum /= numbers.get(i + 1).getValueOf();
            } else if(operators.get(i).equals(Operator.TIMES)) {
                valueOfSum *= numbers.get(i + 1).getValueOf();
            }
        }
        return valueOfSum;
    }
}
