package nl.visser.joram.mathapp.calculationModule;

import java.util.LinkedList;

public class Calculator {

    public static boolean calculateSumEqualsUserInputNumber(Sum sum, MathAppNumber userInputNumber) {
        LinkedList<SumComponent> sumComponents = sum.getSumComponents();

        sumComponents = lalalalalaLaaa(sumComponents, Operator.TIMES);
        sumComponents = lalalalalaLaaa(sumComponents, Operator.DIVIDED_BY);
        sumComponents = lalalalalaLaaa(sumComponents, Operator.PLUS);
        sumComponents = lalalalalaLaaa(sumComponents, Operator.MINUS);

        MathAppNumberImpl mathAppNumber = (MathAppNumberImpl) sumComponents.get(0);

        return mathAppNumber.getValueOf() == userInputNumber.getValueOf();
    }

    public static LinkedList<SumComponent> lalalalalaLaaa(LinkedList<SumComponent> sumComponents, Operator operator) {
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
                    double result = CalculatorForTwoValues.calculateProduct(first, operator, second);
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
