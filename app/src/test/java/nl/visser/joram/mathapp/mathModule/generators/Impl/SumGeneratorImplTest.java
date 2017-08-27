package nl.visser.joram.mathapp.mathModule.generators.Impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import nl.visser.joram.mathapp.bundles.Category;
import nl.visser.joram.mathapp.mathModule.generators.MathAppNumberGenerator;
import nl.visser.joram.mathapp.mathModule.generators.OperatorGenerator;
import nl.visser.joram.mathapp.mathModule.sumComponents.MathAppNumberImpl;
import nl.visser.joram.mathapp.mathModule.sumComponents.Operator;
import nl.visser.joram.mathapp.mathModule.sumComponents.Sum;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SumGeneratorImplTest {

    private SumGeneratorImpl sumGeneratorImpl = new SumGeneratorImpl();

    @Mock
    private MathAppNumberGenerator mathAppNumberGenerator;

    @Mock
    private OperatorGenerator operatorGenerator;

    private MathAppNumberImpl mathAppNumberImpl8 = new MathAppNumberImpl(8);
    private Operator operator = Operator.PLUS;

    @Before
    public void setUp() throws Exception {
        when(mathAppNumberGenerator.generateRandomMathAppNumber(anyInt(), anyInt())).thenReturn(mathAppNumberImpl8);
        when(operatorGenerator.generateRandomOperator(anyListOf(Category.class))).thenReturn(operator);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void givenSomeDifficultyAndSomeCategoriesWhenGenerateRandomSumThenReturnsSum() throws Exception {
        List<Category> categories = new ArrayList<>();
        categories.add(Category.ADDITIONS);
        categories.add(Category.SUBTRACTIONS);
        Sum sum = sumGeneratorImpl.generateRandomSum(2, categories);

        assertThat(sum.getNumbersOfSum().size(), is(equalTo(3)));
        assertThat(sum.getOperatorsOfSum().size(), is(equalTo(2)));
    }

    //TODO make test above more meaningful, write more tests. Make SumGenerator better!

}
