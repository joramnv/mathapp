package nl.visser.joram.mathapp.CalculationModule;

import java.util.ArrayList;
import java.util.Random;

import nl.visser.joram.mathapp.Fragments.Category;

public class SumGenerator {

    Random rand;

    public SumGenerator() {
        rand = new Random();
    }

    public Sum generateRandomSum(int difficulty, ArrayList<Category> categories) {
        Sum newSum = new Sum();
        int min = 2;
        int digitMin = 1;
        int max = difficulty;
        int amountOfNumbersInSum = rand.nextInt((3-min)+1)+min;

        for(int i = 0; i<amountOfNumbersInSum; i++) {
            MathAppNumber n1 = new MathAppNumber();
            int amountOfDigits = rand.nextInt((difficulty-digitMin)+1)+digitMin;
            for(int j = 0; j <amountOfDigits; j++) {
                n1.pushDigit(Digit.randomDigit());
            }
            newSum.pushNumber(n1);
            if(i <amountOfNumbersInSum-1) {
                int randomCategoryIndex = rand.nextInt(categories.size());
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
