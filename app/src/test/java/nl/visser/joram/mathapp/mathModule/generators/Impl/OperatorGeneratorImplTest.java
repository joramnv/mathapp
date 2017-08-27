package nl.visser.joram.mathapp.mathModule.generators.Impl;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import nl.visser.joram.mathapp.bundles.Category;
import nl.visser.joram.mathapp.mathModule.sumComponents.Operator;

public class OperatorGeneratorImplTest {

    private OperatorGeneratorImpl operatorGeneratorImpl = new OperatorGeneratorImpl();

    private List<Category> allCategories = new ArrayList<>();
    private List<Category> additionsAndSubtractions = new ArrayList<>();


    @Before
    public void setUp() throws Exception {
        allCategories.add(Category.ADDITIONS);
        allCategories.add(Category.SUBTRACTIONS);
        allCategories.add(Category.MULTIPLICATIONS);
        allCategories.add(Category.DIVISIONS);

        additionsAndSubtractions.add(Category.ADDITIONS);
        additionsAndSubtractions.add(Category.SUBTRACTIONS);
    }

    @Test
    public void generateRandomOperator() throws Exception {

        Operator operator = operatorGeneratorImpl.generateRandomOperator(allCategories);
        //TODO write test

    }

    //TODO write more tests.

}
