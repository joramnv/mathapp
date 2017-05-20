package nl.visser.joram.mathapp.calculationModule.generators.Impl;

import nl.visser.joram.mathapp.calculationModule.Digit;
import nl.visser.joram.mathapp.calculationModule.MathAppNumberImpl;
import nl.visser.joram.mathapp.calculationModule.generators.DigitGenerator;
import nl.visser.joram.mathapp.calculationModule.generators.MathAppNumberGenerator;

public class MathAppNumberGeneratorImpl implements MathAppNumberGenerator {

    private DigitGenerator digitGenerator = new DigitGeneratorImpl();

    public MathAppNumberImpl generateRandomMathAppNumber(int difficulty, int digitMin) {
        MathAppNumberImpl numberInSum = new MathAppNumberImpl();
        int amountOfDigits = RANDOM.nextInt((difficulty-digitMin)+1)+digitMin;
        for(int i = 0; i < amountOfDigits; i++) {
            Digit randomDigit = digitGenerator.generateRandomDigit();
            if (i == 0) {
                while (randomDigit == Digit.ZERO) {
                    randomDigit = digitGenerator.generateRandomDigit();
                }
            }
            numberInSum.pushDigit(randomDigit);
        }
        return numberInSum;
    }

}
