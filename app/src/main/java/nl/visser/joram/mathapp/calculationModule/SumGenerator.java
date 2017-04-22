package nl.visser.joram.mathapp.calculationModule;

import java.util.List;
import java.util.Random;

import nl.visser.joram.mathapp.bundles.Category;

import static nl.visser.joram.mathapp.calculationModule.MathAppNumber.createNewMathAppNumber;
import static nl.visser.joram.mathapp.calculationModule.Operator.getOperator;

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
            MathAppNumber numberInSum = createNewMathAppNumber(difficulty, digitMin);
            newSum.pushNumber(numberInSum);
            if(i < amountOfNumbersInSum-1) {
                Operator operator = getOperator(categories);
                newSum.pushOperator(operator);
            }
        }
        return newSum;
    }

}
