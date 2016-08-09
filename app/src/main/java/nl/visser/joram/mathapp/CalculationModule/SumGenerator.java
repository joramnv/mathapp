package nl.visser.joram.mathapp.CalculationModule;

import java.util.ArrayList;
import java.util.List;
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
        int amountOfNumbersInSum = random.nextInt((max - min) + 1) + min;

        for (int i = 0; i < amountOfNumbersInSum; i++) {
            MathAppNumber numberInSum = new MathAppNumber();
            int amountOfDigits = random.nextInt((difficulty - digitMin) + 1) + digitMin;
            for (int j = 0; j < amountOfDigits; j++) {

                Digit digit = Digit.randomDigit();
                if(amountOfDigits >1 && j ==0) {
                    while(digit.equals(Digit.ZERO)) {
                        digit = Digit.randomDigit();
                    }
                }
                numberInSum.pushDigit(digit);
            }
            newSum.pushNumber(numberInSum);
            if (i < amountOfNumbersInSum - 1) {
                int randomCategoryIndex = random.nextInt(categories.size());
                Category category = categories.get(randomCategoryIndex);
                switch (category) {
                    case ADDITIONS:
                        newSum.pushOperator(Operator.PLUS);
                        break;
                    case SUBTRACTIONS:
                        newSum.pushOperator(Operator.MINUS);
                        break;
                    case MULTIPLICATIONS:
                        newSum.pushOperator(Operator.TIMES);
                        break;
                    case DIVISIONS:
                        newSum.pushOperator(Operator.DIVIDEDBY);
                        break;
                }
            }
        }
        if(!checkSum(newSum)) {
            ArrayList<Category> categoryArray = new ArrayList<>();
            categoryArray.add(Category.DIVISIONS);
            return generateRandomSum(2, categoryArray);
        }

        return newSum;
    }

    private boolean checkSum(Sum sum) {
        List<MathAppNumber> numbersOfSum = sum.getNumbersOfSum();
        List<Operator> operatorsOfSum = sum.getOperatorsOfSum();

        for (int i = 0; i < numbersOfSum.size() - 1; i++) {
            if (operatorsOfSum.get(i).equals(Operator.DIVIDEDBY)) {
                try {
                    if (numbersOfSum.get(i).getValueOf() % numbersOfSum.get(i + 1).getValueOf() != 0) {
                        return false;

                    }
                } catch (ArithmeticException ex) {
                    return false;
                }
            }
        }
        return true;
    }
}


