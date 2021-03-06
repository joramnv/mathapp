package nl.visser.joram.mathapp.calculationModule;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Sum implements Serializable{

    private List<MathAppNumber> numbersOfSum;
    private List<Operator> operatorsOfSum;

    public Sum() {
        numbersOfSum = new ArrayList<>();
        operatorsOfSum = new ArrayList<>();
    }

    public List<MathAppNumber> getNumbersOfSum() {
        return numbersOfSum;
    }

    public List<Operator> getOperatorsOfSum() {
        return operatorsOfSum;
    }

    public void pushNumber(MathAppNumber number) {
        numbersOfSum.add(number);
    }

    public void pushOperator(Operator operator) {
        operatorsOfSum.add(operator);
    }

}
