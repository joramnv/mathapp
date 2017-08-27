package nl.visser.joram.mathapp.mathModule.calculators;

import java.util.LinkedList;

import nl.visser.joram.mathapp.mathModule.sumComponents.MathAppNumber;
import nl.visser.joram.mathapp.mathModule.sumComponents.MathAppNumberImpl;
import nl.visser.joram.mathapp.mathModule.sumComponents.Operator;
import nl.visser.joram.mathapp.mathModule.sumComponents.Sum;
import nl.visser.joram.mathapp.mathModule.sumComponents.SumComponent;

public class Calculator {

    private CalculatorForTwoValues calculatorForTwoValues = new CalculatorForTwoValues();

    public boolean evaluateSumEqualsUserInputNumber(Sum sum, MathAppNumber userInputNumber) {

        MathAppNumber mathAppNumber = calculateSum(sum);

        return mathAppNumber.getValueOf() == userInputNumber.getValueOf();
    }

    public MathAppNumber calculateSum(Sum sum) {
        LinkedList<SumComponent> sumComponents = sum.getSumComponents();

        sumComponents = calculateBasedOnPriority(sumComponents, Operator.TIMES);
        sumComponents = calculateBasedOnPriority(sumComponents, Operator.DIVIDED_BY);
        sumComponents = calculateBasedOnPriority(sumComponents, Operator.PLUS);
        sumComponents = calculateBasedOnPriority(sumComponents, Operator.MINUS);

        MathAppNumberImpl mathAppNumber = (MathAppNumberImpl) sumComponents.get(0);

        return mathAppNumber;
    }

    public LinkedList<SumComponent> calculateBasedOnPriority(LinkedList<SumComponent> sumComponents, Operator operator) {
        //TODO give own delegate.
        //TODO Write solid tests.
        //TODO Refactor using streams.
        for (int i = 0; i < sumComponents.size(); i++) {
            if (sumComponents.get(i) == operator) {
                double first = 0;
                if (sumComponents.get(i-1) instanceof MathAppNumber) {
                    MathAppNumber mathAppNumber = (MathAppNumber) sumComponents.get(i-1);
                    first = mathAppNumber.getValueOf();
                }
                double second = 0;
                if (sumComponents.get(i+1) instanceof MathAppNumber) {
                    MathAppNumber mathAppNumber = (MathAppNumber) sumComponents.get(i+1);
                    second = mathAppNumber.getValueOf();
                }
                if (first != 0 && second != 0) {
                    double result = calculatorForTwoValues.calculateProduct(first, operator, second);
                    SumComponent mathAppNumber = new MathAppNumberImpl(result);
                    sumComponents.set(i - 1, mathAppNumber);
                    sumComponents.remove(i);
                    sumComponents.remove(i);
                    i--;
                }
            }
        }
        return sumComponents;
    }

}
