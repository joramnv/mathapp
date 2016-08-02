package nl.visser.joram.mathapp.CalculationModule;

import java.util.ArrayList;
import java.util.Random;

import nl.visser.joram.mathapp.Fragments.Category;

public class SumGenerator {

    Random random;

    public SumGenerator() {
        random = new Random();
    }

    public Sum generateRandomSum(int difficulty, ArrayList<Category> categories) {
        Sum newSum = new Sum();
        int min = 2;
        int digitMin = 1;
        int max = difficulty; //TODO use difficulty
        max = 3;
        int amountOfNumbersInSum = random.nextInt((max-min)+1)+min;

        for(int i = 0; i<amountOfNumbersInSum; i++) {
            MathAppNumber numberInSum = new MathAppNumber();
            int amountOfDigits = random.nextInt((difficulty-digitMin)+1)+digitMin;
            for(int j = 0; j <amountOfDigits; j++) {
                numberInSum.pushDigit(Digit.randomDigit());
            }
            newSum.pushNumber(numberInSum);
            if(i <amountOfNumbersInSum-1) {
                int randomCategoryIndex = random.nextInt(categories.size());
                Category category = categories.get(randomCategoryIndex);
                if (category.equals(Category.ADDITIONS)) {
                    newSum.pushOperator(Operator.PLUS);
                } else if(category.equals(Category.SUBTRACTIONS)) {
                    newSum.pushOperator(Operator.MINUS);
                }
            }
        }
        return newSum;
    }
}
