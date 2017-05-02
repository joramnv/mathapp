package nl.visser.joram.mathapp.calculationModule;

import java.util.List;
import java.util.Random;

import nl.visser.joram.mathapp.bundles.Category;

import static nl.visser.joram.mathapp.calculationModule.MathAppNumberGenerator.generateRandomMathAppNumber;
import static nl.visser.joram.mathapp.calculationModule.Operator.getRandomOperator;

public class SumGenerator {

    private static final Random RANDOM = new Random();

    public Sum generateRandomSum(int difficulty, List<Category> categories) {
        Sum newSum = new Sum();
        int min = 2;
        int digitMin = 1;
        int max = difficulty; //TODO use difficulty
        max = 3;
        int amountOfNumbersInSum = RANDOM.nextInt((max-min)+1)+min;

        for(int i = 0; i < amountOfNumbersInSum; i++) {
            MathAppNumber numberInSum = generateRandomMathAppNumber(difficulty, digitMin);
            newSum.pushNumber(numberInSum);
            if(i < amountOfNumbersInSum-1) {
                Operator operator = getRandomOperator(categories);
                newSum.pushOperator(operator);
            }
        }
        return newSum;
    }

}
