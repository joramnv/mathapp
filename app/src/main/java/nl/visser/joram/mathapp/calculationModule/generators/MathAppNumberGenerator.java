package nl.visser.joram.mathapp.calculationModule.generators;

import nl.visser.joram.mathapp.calculationModule.Digit;
import nl.visser.joram.mathapp.calculationModule.MathAppNumberImpl;

public class MathAppNumberGenerator extends RandomGenerator {

    public static MathAppNumberImpl generateRandomMathAppNumber(int difficulty, int digitMin) {
        MathAppNumberImpl numberInSum = new MathAppNumberImpl();
        int amountOfDigits = RANDOM.nextInt((difficulty-digitMin)+1)+digitMin;
        for(int i = 0; i < amountOfDigits; i++) {
            Digit randomDigit = DigitGenerator.generateRandomDigit();
            if (i == 0) {
                while (randomDigit == Digit.ZERO) {
                    randomDigit = DigitGenerator.generateRandomDigit();
                }
            }
            numberInSum.pushDigit(randomDigit);
        }
        return numberInSum;
    }

}
