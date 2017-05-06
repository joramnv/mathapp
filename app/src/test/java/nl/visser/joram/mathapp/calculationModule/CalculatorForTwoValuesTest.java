package nl.visser.joram.mathapp.calculationModule;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class CalculatorForTwoValuesTest {

    @Test
    public void given17Plus14WhenCalculateProductIsCalledThenCalculateProductReturns31() throws Exception {
        double actual = CalculatorForTwoValues.calculateProduct(17, Operator.PLUS, 14);
        double expected = 31;
        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void given14Minus17WhenCalculateProductIsCalledThenCalculateProductReturnsMinus3() throws Exception {
        double actual = CalculatorForTwoValues.calculateProduct(14, Operator.MINUS, 17);
        double expected = -3;
        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void given31Times99WhenCalculateProductIsCalledThenCalculateProductReturns3069() throws Exception {
        double actual = CalculatorForTwoValues.calculateProduct(31, Operator.TIMES, 99);
        double expected = 3069;
        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void given35DividedBy6WhenCalculateProductIsCalledThenCalculateProductReturns5Dot833333333333333() throws Exception {
        double actual = CalculatorForTwoValues.calculateProduct(35, Operator.DIVIDED_BY, 6);
        double expected = 5.833333333333333;
        assertThat(actual, is(equalTo(expected)));
    }

}
