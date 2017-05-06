package nl.visser.joram.mathapp.calculationModule;

import java.util.Random;

public class MathAppNumberGenerator {

    private static final Random RANDOM = new Random();

    public static MathAppNumberImpl generateRandomMathAppNumber(int difficulty, int digitMin) {
        MathAppNumberImpl numberInSum = new MathAppNumberImpl();
        int amountOfDigits = RANDOM.nextInt((difficulty-digitMin)+1)+digitMin;
        for(int i = 0; i < amountOfDigits; i++) {
            Digit randomDigit = Digit.randomDigit();
            if (i == 0) {
                while (randomDigit == Digit.ZERO) {
                    randomDigit = Digit.randomDigit();
                }
            }
            numberInSum.pushDigit(randomDigit);
        }
        return numberInSum;
    }

}
