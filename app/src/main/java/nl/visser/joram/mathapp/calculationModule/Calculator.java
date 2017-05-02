package nl.visser.joram.mathapp.calculationModule;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public static boolean calculateSumEqualsUserInputNumber(Sum sum, MathAppNumber userInputNumber) {
        List<MathAppNumber> mathAppNumbers = sum.getNumbersOfSum();
        List<Double> numbers = new ArrayList<>();
        for (MathAppNumber mathAppNumber : mathAppNumbers) {
            numbers.add(mathAppNumber.getValueOf());
        }
        List<Operator> operators = sum.getOperatorsOfSum();
        //TODO clean up and rename method
        for (int i = 0; i< operators.size(); i++) {
            if (operators.get(i) == Operator.TIMES) {
                numbers = calculateSomeThingAndReturnSomething(numbers, i, Operator.TIMES);
                operators.remove(i);
            }
        }

        for (int i = 0; i< operators.size(); i++) {
            if (operators.get(i) == Operator.DIVIDED_BY) {
                numbers = calculateSomeThingAndReturnSomething(numbers, i, Operator.DIVIDED_BY);
                operators.remove(i);
            }
        }

        for (int i = 0; i< operators.size(); i++) {
            if (operators.get(i) == Operator.PLUS) {
                numbers = calculateSomeThingAndReturnSomething(numbers, i, Operator.PLUS);
                operators.remove(i);
            }
        }

        for (int i = 0; i< operators.size(); i++) {
            if (operators.get(i) == Operator.MINUS) {
                numbers = calculateSomeThingAndReturnSomething(numbers, i, Operator.MINUS);
                operators.remove(i);
            }
        }

        double totalNumber = 0;

        for (double number : numbers) {
            totalNumber += number;
        }

        return totalNumber == userInputNumber.getValueOf();
    }

    public static List<Double> calculateSomeThingAndReturnSomething(List<Double> numbers, int i, Operator operator) {
        double result = CalculatorForTwoValues.calculateProduct(numbers.get(i), operator, numbers.get(i+1));
        numbers.set(i, result);
        numbers.remove(i+1);
        return numbers;
    }

}
