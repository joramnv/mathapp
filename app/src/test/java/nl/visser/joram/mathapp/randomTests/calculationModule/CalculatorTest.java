package nl.visser.joram.mathapp.randomTests.calculationModule;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import nl.visser.joram.mathapp.calculationModule.Calculator;
import nl.visser.joram.mathapp.calculationModule.Digit;
import nl.visser.joram.mathapp.calculationModule.MathAppNumber;
import nl.visser.joram.mathapp.calculationModule.Operator;
import nl.visser.joram.mathapp.calculationModule.Sum;

import static org.junit.Assert.assertTrue;

public class CalculatorTest {

    private Calculator calculator;
    private Sum sum;
    private MathAppNumber mathAppNumber1, mathAppNumber2;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();

        Digit randomDigit1 = Digit.randomDigit();
        Digit randomDigit2 = Digit.randomDigit();
        Digit randomDigit3 = Digit.randomDigit();
        Digit randomDigit4 = Digit.randomDigit();

        mathAppNumber1 = new MathAppNumber();
        mathAppNumber1.initiate();
        mathAppNumber1.pushDigit(randomDigit1);
        mathAppNumber1.pushDigit(randomDigit2);

        mathAppNumber2 = new MathAppNumber();
        mathAppNumber2.initiate();
        mathAppNumber2.pushDigit(randomDigit3);
        mathAppNumber2.pushDigit(randomDigit4);

        sum = new Sum();
        sum.pushNumber(mathAppNumber1);
        sum.pushNumber(mathAppNumber2);
        sum.pushOperator(Operator.PLUS);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void givenGOODGOODWhenCalculateSumEqualsUserInputNumberIsCalledThenCalculateSumEqualsUserInputNumberReturnsTrue() throws Exception {
        int firstNumber = mathAppNumber1.getValueOf();
        int secondNumber = mathAppNumber2.getValueOf();
        int answer = firstNumber + secondNumber;

        MathAppNumber mathAppNumber = createNewMathAppNumber(answer);

        boolean b = calculator.calculateSumEqualsUserInputNumber(sum, mathAppNumber);
        assertTrue(b);
    }

    private MathAppNumber createNewMathAppNumber(int answer) {
        MathAppNumber mathAppNumber = new MathAppNumber();
        mathAppNumber.initiate();

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
            mathAppNumber.pushDigit(digit);
        }
        return mathAppNumber;
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
