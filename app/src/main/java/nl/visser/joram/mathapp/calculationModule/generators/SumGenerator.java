package nl.visser.joram.mathapp.calculationModule.generators;

import java.util.List;

import nl.visser.joram.mathapp.bundles.Category;
import nl.visser.joram.mathapp.calculationModule.Sum;
import nl.visser.joram.mathapp.calculationModule.SumComponent;

import static nl.visser.joram.mathapp.calculationModule.generators.MathAppNumberGenerator.generateRandomMathAppNumber;
import static nl.visser.joram.mathapp.calculationModule.generators.OperatorGenerator.generateRandomOperator;

public class SumGenerator extends RandomGenerator {

    public static Sum generateRandomSum(int difficulty, List<Category> categories) {
        Sum newSum = new Sum();
        int min = 2;
        int digitMin = 1;
        int max = difficulty; //TODO use difficulty
        max = 3;
        int amountOfNumbersInSum = RANDOM.nextInt((max-min)+1)+min;

        for(int i = 0; i < amountOfNumbersInSum; i++) {
            SumComponent numberInSum = generateRandomMathAppNumber(difficulty, digitMin);
            newSum.add(numberInSum);
            if(i < amountOfNumbersInSum-1) {
                SumComponent operator = generateRandomOperator(categories);
                newSum.add(operator);
            }
        }
        return newSum;
    }

}
