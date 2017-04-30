package nl.visser.joram.mathapp.unitTests.calculationModule;

import org.junit.Before;
import org.junit.Test;

import nl.visser.joram.mathapp.calculationModule.Calculator;
import nl.visser.joram.mathapp.calculationModule.Digit;
import nl.visser.joram.mathapp.calculationModule.MathAppNumber;
import nl.visser.joram.mathapp.calculationModule.Operator;
import nl.visser.joram.mathapp.calculationModule.Sum;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CalculatorTest {

    private Calculator calculator;
    private Sum sum;
    private MathAppNumber mathAppNumber84, mathAppNumber37;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();

        mathAppNumber84 = new MathAppNumber();
        mathAppNumber84.initiate();
        mathAppNumber84.pushDigit(Digit.EIGHT);
        mathAppNumber84.pushDigit(Digit.FOUR);

        mathAppNumber37 = new MathAppNumber();
        mathAppNumber37.initiate();
        mathAppNumber37.pushDigit(Digit.THREE);
        mathAppNumber37.pushDigit(Digit.SEVEN);

        sum = new Sum();
        sum.pushNumber(mathAppNumber84);
        sum.pushNumber(mathAppNumber37);
        sum.pushOperator(Operator.PLUS);

    }

    @Test
    public void givenEightyFourPlusThirtySevenWhenCalculateSumEqualsUserInputNumberIsCalledThenCalculateSumEqualsUserInputNumberReturnsTrue() throws Exception {
        int answer = mathAppNumber84.getValueOf() + mathAppNumber37.getValueOf();

        MathAppNumber mathAppNumber = createNewMathAppNumber(answer);

        boolean actual = calculator.calculateSumEqualsUserInputNumber(sum, mathAppNumber);
        assertThat(actual, is(true));
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

    private Digit getDigitBelongingTo(int value) {
        switch (value) {
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
