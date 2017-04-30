package nl.visser.joram.mathapp.calculationModule;

public class CalculatorForTwoValues {

    public static double calculateProduct(double valueOne, Operator operator, double valueTwo) {
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
