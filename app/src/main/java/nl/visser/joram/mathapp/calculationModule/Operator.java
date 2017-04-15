package nl.visser.joram.mathapp.calculationModule;

import java.util.List;
import java.util.Random;

import nl.visser.joram.mathapp.R;
import nl.visser.joram.mathapp.fragments.Category;

public enum Operator{
    MINUS (R.drawable.minus),
    PLUS (R.drawable.plus),
    EQUALS(R.drawable.equals),
    TIMES(R.drawable.times),
    DIVIDED_BY(R.drawable.division),
    BACK(0),
    CLEAR(0);

    private int drawable;
    private static Random random = new Random();

    Operator(int drawable) {
        this.drawable = drawable;
    }

    public int getDrawable() {
        return drawable;
    }

    public static Operator getOperator(List<Category> categories) {
        int randomCategoryIndex = random.nextInt(categories.size());
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
