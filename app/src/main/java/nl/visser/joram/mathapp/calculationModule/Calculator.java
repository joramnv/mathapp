package nl.visser.joram.mathapp.calculationModule;

import java.util.List;

public class Calculator {

    public boolean calculateSumEqualsUserInputNumber(Sum sum, MathAppNumber userInputNumber) {
        List<MathAppNumber> numbers = sum.getNumbersOfSum();
        List<Operator> operators = sum.getOperatorsOfSum();
        int valueOfSum = numbers.get(0).getValueOf();
        for(int i = 0; i< operators.size(); i++) {
            valueOfSum = CalculatorForTwoValues.calculateProduct(valueOfSum, operators.get(i), numbers.get(i+1).getValueOf());
        }
        return valueOfSum == userInputNumber.getValueOf();
    }

}
