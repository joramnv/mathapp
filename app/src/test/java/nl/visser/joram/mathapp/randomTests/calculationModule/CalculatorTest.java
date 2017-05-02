package nl.visser.joram.mathapp.randomTests.calculationModule;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import nl.visser.joram.mathapp.calculationModule.Calculator;
import nl.visser.joram.mathapp.calculationModule.Digit;
import nl.visser.joram.mathapp.calculationModule.MathAppNumberImpl;
import nl.visser.joram.mathapp.calculationModule.Operator;
import nl.visser.joram.mathapp.calculationModule.Sum;

import static org.junit.Assert.assertTrue;

public class CalculatorTest {

    private Calculator calculator;
    private Sum sum;
    private MathAppNumberImpl mathAppNumberImpl1, mathAppNumberImpl2;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();

        Digit randomDigit1 = Digit.randomDigit();
        Digit randomDigit2 = Digit.randomDigit();
        Digit randomDigit3 = Digit.randomDigit();
        Digit randomDigit4 = Digit.randomDigit();

        mathAppNumberImpl1 = new MathAppNumberImpl();
        mathAppNumberImpl1.initiate();
        mathAppNumberImpl1.pushDigit(randomDigit1);
        mathAppNumberImpl1.pushDigit(randomDigit2);

        mathAppNumberImpl2 = new MathAppNumberImpl();
        mathAppNumberImpl2.initiate();
        mathAppNumberImpl2.pushDigit(randomDigit3);
        mathAppNumberImpl2.pushDigit(randomDigit4);

        sum = new Sum();
        sum.pushNumber(mathAppNumberImpl1);
        sum.pushNumber(mathAppNumberImpl2);
        sum.pushOperator(Operator.PLUS);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void givenGOODGOODWhenCalculateSumEqualsUserInputNumberIsCalledThenCalculateSumEqualsUserInputNumberReturnsTrue() throws Exception {
        double firstNumber = mathAppNumberImpl1.getValueOf();
        double secondNumber = mathAppNumberImpl2.getValueOf();
        double answer = firstNumber + secondNumber;

        MathAppNumberImpl mathAppNumberImpl = createNewMathAppNumber(answer);

        boolean b = Calculator.calculateSumEqualsUserInputNumber(sum, mathAppNumberImpl);
        assertTrue(b);
    }

    private MathAppNumberImpl createNewMathAppNumber(double answer) {
        MathAppNumberImpl mathAppNumberImpl = new MathAppNumberImpl();
        mathAppNumberImpl.initiate();

        String answerAsString = String.valueOf(answer);
        int amountOfDigits = answerAsString.length();
        for(int i = 0; i < amountOfDigits; i++) {

            char charAt = answerAsString.charAt(i);
            int g = Character.getNumericValue(charAt);

            Digit digit = getDigitBelongingTo(g);
            if (i == 0) {
                while (digit == Digit.ZERO) {
                    digit = Digit.randomDigit();
                }
            }
            mathAppNumberImpl.pushDigit(digit);
        }
        return mathAppNumberImpl;
    }

    private Digit getDigitBelongingTo(int i) {
        switch (i) {
            case 0: return Digit.ZERO;
            case 1: return Digit.ONE;
            case 2: return Digit.TWO;
            case 3: return Digit.THREE;
            case 4: return Digit.FOUR;
            case 5: return Digit.FIVE;
            case 6: return Digit.SIX;
            case 7: return Digit.SEVEN;
            case 8: return Digit.EIGHT;
            case 9: return Digit.NINE;
        }
        return Digit.ZERO;
    }

}
