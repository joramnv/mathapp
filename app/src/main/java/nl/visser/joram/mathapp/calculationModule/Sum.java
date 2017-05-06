package nl.visser.joram.mathapp.calculationModule;

import java.io.Serializable;
import java.util.LinkedList;

public class Sum implements Serializable {

    private LinkedList<SumComponent> sumComponents;

    public Sum() {
        sumComponents = new LinkedList<>();
    }

    public LinkedList<MathAppNumberImpl> getNumbersOfSum() {
        LinkedList<MathAppNumberImpl> numbers = new LinkedList<>();
        for (SumComponent sumComponent : sumComponents) {
            if (sumComponent instanceof MathAppNumberImpl) {
                numbers.add((MathAppNumberImpl) sumComponent);
            }
        }
        return numbers;
    }

    public LinkedList<Operator> getOperatorsOfSum() {
        LinkedList<Operator> operators = new LinkedList<>();
        for (SumComponent sumComponent : sumComponents) {
            if (sumComponent instanceof Operator) {
                operators.add((Operator) sumComponent);
            }
        }
        return operators;
    }

    public void add(SumComponent sumComponent) {
        sumComponents.add(sumComponent);
    }

    public LinkedList<SumComponent> getSumComponents() {
        return sumComponents;
    }

}
