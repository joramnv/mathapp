package nl.visser.joram.mathapp.calculationModule.generators;

import java.util.List;

import nl.visser.joram.mathapp.bundles.Category;
import nl.visser.joram.mathapp.calculationModule.Operator;

public class OperatorGenerator extends RandomGenerator {

    public static Operator generateRandomOperator(List<Category> categories) {
        int randomCategoryIndex = RANDOM.nextInt(categories.size());
        Category category = categories.get(randomCategoryIndex);
        if (category.equals(Category.ADDITIONS)) {
            return Operator.PLUS;
        } else if(category.equals(Category.SUBTRACTIONS)) {
            return Operator.MINUS;
        } else if (category.equals(Category.MULTIPLICATIONS)) {
            return Operator.TIMES;
        } else if(category.equals(Category.DIVISIONS)) {
            return Operator.DIVIDED_BY;
        }
        return Operator.PLUS;
    }

}
