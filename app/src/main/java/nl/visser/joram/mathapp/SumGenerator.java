package nl.visser.joram.mathapp;

public class SumGenerator {

    MathAppNumber n1;
    MathAppNumber n2;

    public SumGenerator() {

    }

    public Sum generateRandomSum() {

        n1 = new MathAppNumber();
        n1.pushDigit(Digit.randomDigit());
        n2 = new MathAppNumber();
        n2.pushDigit(Digit.randomDigit());

        Sum newSum = new Sum();
        newSum.pushNumber(n1);
        newSum.pushNumber(n2);
        newSum.pushOperator(Operator.PLUS);

        return newSum;
    }
}
