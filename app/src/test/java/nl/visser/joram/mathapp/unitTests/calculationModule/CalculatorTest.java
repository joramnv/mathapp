package nl.visser.joram.mathapp.unitTests.calculationModule;

import org.junit.Ignore;
import org.junit.Test;

import nl.visser.joram.mathapp.calculationModule.Calculator;
import nl.visser.joram.mathapp.calculationModule.Digit;
import nl.visser.joram.mathapp.calculationModule.MathAppNumber;
import nl.visser.joram.mathapp.calculationModule.Operator;
import nl.visser.joram.mathapp.calculationModule.Sum;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CalculatorTest {

    @Test
    public void givenEightyFourPlusThirtySevenWhenCalculateSumEqualsUserInputNumberIsCalledThenCalculateSumEqualsUserInputNumberReturnsTrue() throws Exception {
        MathAppNumber mathAppNumber84 = new MathAppNumber();
        mathAppNumber84.initiate();
        mathAppNumber84.pushDigit(Digit.EIGHT);
        mathAppNumber84.pushDigit(Digit.FOUR);

        MathAppNumber mathAppNumber37 = new MathAppNumber();
        mathAppNumber37.initiate();
        mathAppNumber37.pushDigit(Digit.THREE);
        mathAppNumber37.pushDigit(Digit.SEVEN);

        Sum sum = new Sum();
        sum.pushNumber(mathAppNumber84);
        sum.pushNumber(mathAppNumber37);
        sum.pushOperator(Operator.PLUS);

        int answer = mathAppNumber84.getValueOf() + mathAppNumber37.getValueOf();

        MathAppNumber mathAppNumber = createNewMathAppNumber(answer);

        boolean actual = Calculator.calculateSumEqualsUserInputNumber(sum, mathAppNumber);
        assertThat(actual, is(true));
    }

    //TODO make this test work so the difference between 4 + 6 * 10 = 64 and (4 + 6) * 10 = 100
    @Ignore
    @Test
    public void givenThisTestThingOke() throws Exception {
        MathAppNumber mathAppNumber4 = new MathAppNumber();
        mathAppNumber4.initiate();
        mathAppNumber4.pushDigit(Digit.FOUR);

        MathAppNumber mathAppNumber6 = new MathAppNumber();
        mathAppNumber6.initiate();
        mathAppNumber6.pushDigit(Digit.SIX);

        MathAppNumber mathAppNumber10 = new MathAppNumber();
        mathAppNumber10.initiate();
        mathAppNumber10.pushDigit(Digit.ONE);
        mathAppNumber10.pushDigit(Digit.ZERO);

        Sum sum = new Sum();
        sum.pushNumber(mathAppNumber4);
        sum.pushNumber(mathAppNumber6);
        sum.pushNumber(mathAppNumber10);
        sum.pushOperator(Operator.PLUS);
        sum.pushOperator(Operator.TIMES);

        int answer = mathAppNumber4.getValueOf() + mathAppNumber6.getValueOf() * mathAppNumber10.getValueOf();

        MathAppNumber mathAppNumber = createNewMathAppNumber(answer);

        boolean actual = Calculator.calculateSumEqualsUserInputNumber(sum, mathAppNumber);
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
