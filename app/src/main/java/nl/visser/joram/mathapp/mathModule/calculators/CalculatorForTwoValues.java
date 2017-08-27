package nl.visser.joram.mathapp.mathModule.calculators;

import nl.visser.joram.mathapp.mathModule.sumComponents.Operator;

public class CalculatorForTwoValues {

    public double calculateProduct(double valueOne, Operator operator, double valueTwo) {
        if(Operator.PLUS.equals(operator)) {
            valueOne += valueTwo;
        } else if(Operator.MINUS.equals(operator)) {
            valueOne -= valueTwo;
        } else if(Operator.TIMES.equals(operator)) {
            valueOne *= valueTwo;
        } else if(Operator.DIVIDED_BY.equals(operator)) {
            valueOne /= valueTwo;
        }
        return valueOne;
    }

}
