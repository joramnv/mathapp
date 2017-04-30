package nl.visser.joram.mathapp.randomTests.calculationModule;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import nl.visser.joram.mathapp.bundles.Category;
import nl.visser.joram.mathapp.calculationModule.CalculatorForTwoValues;
import nl.visser.joram.mathapp.calculationModule.Operator;

import static org.junit.Assert.assertEquals;

public class CalculatorForTwoValuesTest {

    private static final Random RANDOM = new Random();
    private static final List<Category> categories = new ArrayList<Category>() {{
        add(Category.ADDITIONS);
        add(Category.SUBTRACTIONS);
        add(Category.MULTIPLICATIONS);
        add(Category.DIVISIONS);
    }};

    private static int randomNumber1, randomNumber2;
    private static Operator randomOperator;

    @Before
    public void setUp() throws Exception {
        randomNumber1 = RANDOM.nextInt(3);
        randomNumber2 = RANDOM.nextInt(3);
        randomOperator = Operator.getRandomOperator(categories);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void calculateProduct() throws Exception {

    }

    @Test
    public void givenTwoRandomValuesAndARandomOperatorWhenCalculateProductIsCalledThenCalculateProductReturnsTheProduct() throws Exception {

        double expectedAnswer = randomNumber1 + randomNumber2;

        double calculatedAnswer = CalculatorForTwoValues.calculateProduct(randomNumber1, Operator.PLUS, randomNumber2);

        assertEquals(expectedAnswer, calculatedAnswer);
    }

}
