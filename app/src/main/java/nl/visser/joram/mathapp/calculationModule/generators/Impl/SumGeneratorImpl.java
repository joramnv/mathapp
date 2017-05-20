package nl.visser.joram.mathapp.calculationModule.generators.Impl;

import java.util.List;

import nl.visser.joram.mathapp.bundles.Category;
import nl.visser.joram.mathapp.calculationModule.Sum;
import nl.visser.joram.mathapp.calculationModule.SumComponent;
import nl.visser.joram.mathapp.calculationModule.generators.MathAppNumberGenerator;
import nl.visser.joram.mathapp.calculationModule.generators.OperatorGenerator;
import nl.visser.joram.mathapp.calculationModule.generators.SumGenerator;

public class SumGeneratorImpl implements SumGenerator{

    private MathAppNumberGenerator mathAppNumberGenerator = new MathAppNumberGeneratorImpl();
    private OperatorGenerator operatorGenerator = new OperatorGeneratorImpl();

    public Sum generateRandomSum(int difficulty, List<Category> categories) {
        Sum newSum = new Sum();
        int min = 2;
        int digitMin = 1;
        int max = difficulty; //TODO use difficulty
        max = 3;
        int amountOfNumbersInSum = RANDOM.nextInt((max-min)+1)+min;

        for(int i = 0; i < amountOfNumbersInSum; i++) {
            SumComponent numberInSum = mathAppNumberGenerator.generateRandomMathAppNumber(difficulty, digitMin);
            newSum.add(numberInSum);
            if(i < amountOfNumbersInSum-1) {
                SumComponent operator = operatorGenerator.generateRandomOperator(categories);
                newSum.add(operator);
            }
        }
        return newSum;
    }

}
