package nl.visser.joram.mathapp.mathModule;

import org.junit.Test;

import nl.visser.joram.mathapp.mathModule.calculators.Calculator;
import nl.visser.joram.mathapp.mathModule.sumComponents.MathAppNumberImpl;
import nl.visser.joram.mathapp.mathModule.sumComponents.Operator;
import nl.visser.joram.mathapp.mathModule.sumComponents.Sum;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void given84Plus37WhenCalculateSumEqualsUserInputNumberIsCalledThenCalculateSumEqualsUserInputNumberReturnsTrue() throws Exception {
        MathAppNumberImpl mathAppNumber84 = new MathAppNumberImpl(84);
        MathAppNumberImpl mathAppNumber37 = new MathAppNumberImpl(37);
        MathAppNumberImpl mathAppNumber121 = new MathAppNumberImpl(121);

        Sum sum = new Sum();
        sum.add(mathAppNumber84);
        sum.add(Operator.PLUS);
        sum.add(mathAppNumber37);

        boolean actual = calculator.evaluateSumEqualsUserInputNumber(sum, mathAppNumber121);
        assertThat(actual, is(true));
    }

    @Test
    public void given4Plus6Times10WhenCalculateSumEqualsUserInputNumberIsCalledThenCalculateSumEqualsUserInputNumberReturnsTrue() throws Exception {
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

        boolean actual = calculator.evaluateSumEqualsUserInputNumber(sum, mathAppNumber64);
        assertThat(actual, is(true));
    }

    @Test
    public void given4Plus6DividedBy10WhenCalculateSumEqualsUserInputNumberIsCalledThenCalculateSumEqualsUserInputNumberReturnsTrue() throws Exception {
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

        boolean actual = calculator.evaluateSumEqualsUserInputNumber(sum, mathAppNumber4Dot6);
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

        boolean actual = calculator.evaluateSumEqualsUserInputNumber(sum, mathAppNumberMinus12);
        assertThat(actual, is(true));
    }

}
