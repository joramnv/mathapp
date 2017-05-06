/*
package nl.visser.joram.mathapp.unitTests.calculationModule;

import org.junit.Test;

import nl.visser.joram.mathapp.calculationModule.Calculator;
import nl.visser.joram.mathapp.calculationModule.Digit;
import nl.visser.joram.mathapp.calculationModule.MathAppNumber;
import nl.visser.joram.mathapp.calculationModule.MathAppNumberImpl;
import nl.visser.joram.mathapp.calculationModule.Operator;
import nl.visser.joram.mathapp.calculationModule.Sum;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CalculatorTest {

    @Test
    public void givenEightyFourPlusThirtySevenWhenCalculateSumEqualsUserInputNumberIsCalledThenCalculateSumEqualsUserInputNumberReturnsTrue() throws Exception {
        MathAppNumber mathAppNumber84 = new MathAppNumberImpl();
        mathAppNumber84.initiate();
        mathAppNumber84.pushDigit(Digit.EIGHT);
        mathAppNumber84.pushDigit(Digit.FOUR);

        MathAppNumber mathAppNumber37 = new MathAppNumberImpl();
        mathAppNumber37.initiate();
        mathAppNumber37.pushDigit(Digit.THREE);
        mathAppNumber37.pushDigit(Digit.SEVEN);

        MathAppNumber mathAppNumber121 = new MathAppNumberImpl();
        mathAppNumber121.initiate();
        mathAppNumber121.pushDigit(Digit.ONE);
        mathAppNumber121.pushDigit(Digit.TWO);
        mathAppNumber121.pushDigit(Digit.ONE);

        Sum sum = new Sum();
        sum.pushNumber(mathAppNumber84);
        sum.pushNumber(mathAppNumber37);
        sum.pushOperator(Operator.PLUS);

        boolean actual = Calculator.calculateSumEqualsUserInputNumber(sum, mathAppNumber121);
        assertThat(actual, is(true));
    }

    @Test
    public void givenFourPlusSixTimesTenWhenCalculateSumEqualsUserInputNumberIsCalledThenCalculateSumEqualsUserInputNumberReturnsTrue() throws Exception {
        MathAppNumber mathAppNumber4 = new MathAppNumberImpl();
        mathAppNumber4.initiate();
        mathAppNumber4.pushDigit(Digit.FOUR);

        MathAppNumber mathAppNumber6 = new MathAppNumberImpl();
        mathAppNumber6.initiate();
        mathAppNumber6.pushDigit(Digit.SIX);

        MathAppNumber mathAppNumber10 = new MathAppNumberImpl();
        mathAppNumber10.initiate();
        mathAppNumber10.pushDigit(Digit.ONE);
        mathAppNumber10.pushDigit(Digit.ZERO);

        MathAppNumber mathAppNumber64 = new MathAppNumberImpl();
        mathAppNumber64.initiate();
        mathAppNumber64.pushDigit(Digit.SIX);
        mathAppNumber64.pushDigit(Digit.FOUR);

        Sum sum = new Sum();
        sum.pushNumber(mathAppNumber4);
        sum.pushNumber(mathAppNumber6);
        sum.pushNumber(mathAppNumber10);
        sum.pushOperator(Operator.PLUS);
        sum.pushOperator(Operator.TIMES);

        boolean actual = Calculator.calculateSumEqualsUserInputNumber(sum, mathAppNumber64);
        assertThat(actual, is(true));
    }

    @Test
    public void givenFourPlusSixDividedByTenWhenCalculateSumEqualsUserInputNumberIsCalledThenCalculateSumEqualsUserInputNumberReturnsTrue() throws Exception {
        MathAppNumber mathAppNumber4 = new MathAppNumberImpl();
        mathAppNumber4.initiate();
        mathAppNumber4.pushDigit(Digit.FOUR);

        MathAppNumber mathAppNumber6 = new MathAppNumberImpl();
        mathAppNumber6.initiate();
        mathAppNumber6.pushDigit(Digit.SIX);

        MathAppNumber mathAppNumber10 = new MathAppNumberImpl();
        mathAppNumber10.initiate();
        mathAppNumber10.pushDigit(Digit.ONE);
        mathAppNumber10.pushDigit(Digit.ZERO);

        MathAppNumber mathAppNumber4Dot6 = new MathAppNumberImpl();
        mathAppNumber4Dot6.initiate();
        mathAppNumber4Dot6.pushDigit(Digit.FOUR);
        mathAppNumber4Dot6.pushDigit(Digit.COMMA);
        mathAppNumber4Dot6.pushDigit(Digit.SIX);

        Sum sum = new Sum();
        sum.pushNumber(mathAppNumber4);
        sum.pushNumber(mathAppNumber6);
        sum.pushNumber(mathAppNumber10);
        sum.pushOperator(Operator.PLUS);
        sum.pushOperator(Operator.DIVIDED_BY);

        boolean actual = Calculator.calculateSumEqualsUserInputNumber(sum, mathAppNumber4Dot6);
        assertThat(actual, is(true));
    }

}
*/
