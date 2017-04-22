package nl.visser.joram.mathapp.calculationModule;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorForTwoValuesTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void calculateProduct() throws Exception {

    }

    @Test
    public void givenTwoRandomValuesAndARandomOperatorWhenCalculateProductIsCalledThenCalculateProductReturnsTheProduct() throws Exception {

        int calculatedAnswer = CalculatorForTwoValues.calculateProduct(3, Operator.TIMES, 1);

        int expectedAnswer = 3;

        assertEquals(expectedAnswer, calculatedAnswer);
    }

}
