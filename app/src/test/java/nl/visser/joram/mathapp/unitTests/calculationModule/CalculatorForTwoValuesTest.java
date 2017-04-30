package nl.visser.joram.mathapp.unitTests.calculationModule;

import org.junit.Test;

import nl.visser.joram.mathapp.calculationModule.CalculatorForTwoValues;
import nl.visser.joram.mathapp.calculationModule.Operator;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class CalculatorForTwoValuesTest {

    @Test
    public void givenSeventeenPlusFourteenWhenCalculateProductIsCalledThenCalculateProductReturnsThirtyOne() throws Exception {
        int actual = CalculatorForTwoValues.calculateProduct(17, Operator.PLUS, 14);
        int expected = 31;
        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void givenSeventeenMinusFourteenWhenCalculateProductIsCalledThenCalculateProductReturnsThirtyOne() throws Exception {
        int actual = CalculatorForTwoValues.calculateProduct(17, Operator.MINUS, 14);
        int expected = 3;
        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void givenThirtyOneTimesNinetyNineWhenCalculateProductIsCalledThenCalculateProductReturnsThreeThousandAndSixtyNine() throws Exception {
        int actual = CalculatorForTwoValues.calculateProduct(31, Operator.TIMES, 99);
        int expected = 3069;
        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void givenThirtyFiveDividedBySixWhenCalculateProductIsCalledThenCalculateProductReturnsFive() throws Exception {
        int actual = CalculatorForTwoValues.calculateProduct(35, Operator.DIVIDED_BY, 6);
        int expected = 5;
        assertThat(actual, is(equalTo(expected)));
    }

}
