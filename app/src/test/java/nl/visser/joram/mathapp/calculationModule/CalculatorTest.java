package nl.visser.joram.mathapp.calculationModule;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CalculatorTest {

    @Test
    public void givenEightyFourPlusThirtySevenWhenCalculateSumEqualsUserInputNumberIsCalledThenCalculateSumEqualsUserInputNumberReturnsTrue() throws Exception {
        MathAppNumberImpl mathAppNumber84 = new MathAppNumberImpl(84);
        MathAppNumberImpl mathAppNumber37 = new MathAppNumberImpl(37);
        MathAppNumberImpl mathAppNumber121 = new MathAppNumberImpl(121);

        Sum sum = new Sum();
        sum.add(mathAppNumber84);
        sum.add(Operator.PLUS);
        sum.add(mathAppNumber37);

        boolean actual = Calculator.calculateSumEqualsUserInputNumber(sum, mathAppNumber121);
        assertThat(actual, is(true));
    }

    @Test
    public void givenFourPlusSixTimesTenWhenCalculateSumEqualsUserInputNumberIsCalledThenCalculateSumEqualsUserInputNumberReturnsTrue() throws Exception {
        MathAppNumberImpl mathAppNumber4 = new MathAppNumberImpl(4);
        MathAppNumberImpl mathAppNumber6 = new MathAppNumberImpl(6);
        MathAppNumberImpl mathAppNumber10 = new MathAppNumberImpl(10);
        MathAppNumberImpl mathAppNumber64 = new MathAppNumberImpl(64);

        Sum sum = new Sum();
        sum.add(mathAppNumber4);
        sum.add(Operator.PLUS);
        sum.add(mathAppNumber6);
        sum.add(Operator.TIMES);
        sum.add(mathAppNumber10);

        boolean actual = Calculator.calculateSumEqualsUserInputNumber(sum, mathAppNumber64);
        assertThat(actual, is(true));
    }

    @Test
    public void givenFourPlusSixDividedByTenWhenCalculateSumEqualsUserInputNumberIsCalledThenCalculateSumEqualsUserInputNumberReturnsTrue() throws Exception {
        MathAppNumberImpl mathAppNumber4 = new MathAppNumberImpl(4);
        MathAppNumberImpl mathAppNumber6 = new MathAppNumberImpl(6);
        MathAppNumberImpl mathAppNumber10 = new MathAppNumberImpl(10);
        MathAppNumberImpl mathAppNumber4Dot6 = new MathAppNumberImpl(4.6);

        Sum sum = new Sum();
        sum.add(mathAppNumber4);
        sum.add(Operator.PLUS);
        sum.add(mathAppNumber6);
        sum.add(Operator.DIVIDED_BY);
        sum.add(mathAppNumber10);

        boolean actual = Calculator.calculateSumEqualsUserInputNumber(sum, mathAppNumber4Dot6);
        assertThat(actual, is(true));
    }

    @Test
    public void given4Minus6Minus10WhenCalculateSumEqualsUserInputNumberIsCalledThenCalculateSumEqualsUserInputNumberReturnsTrue() throws Exception {
        MathAppNumberImpl mathAppNumber4 = new MathAppNumberImpl(4);
        MathAppNumberImpl mathAppNumber6 = new MathAppNumberImpl(6);
        MathAppNumberImpl mathAppNumber10 = new MathAppNumberImpl(10);
        MathAppNumberImpl mathAppNumberMinus12 = new MathAppNumberImpl(-12);

        Sum sum = new Sum();
        sum.add(mathAppNumber4);
        sum.add(Operator.MINUS);
        sum.add(mathAppNumber6);
        sum.add(Operator.MINUS);
        sum.add(mathAppNumber10);

        boolean actual = Calculator.calculateSumEqualsUserInputNumber(sum, mathAppNumberMinus12);
        assertThat(actual, is(true));
    }

}
