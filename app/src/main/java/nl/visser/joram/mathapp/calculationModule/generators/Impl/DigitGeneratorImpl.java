package nl.visser.joram.mathapp.calculationModule.generators.Impl;

import nl.visser.joram.mathapp.calculationModule.Digit;
import nl.visser.joram.mathapp.calculationModule.generators.DigitGenerator;

public class DigitGeneratorImpl implements DigitGenerator {

    public Digit generateRandomDigit() {
        return DIGITS[RANDOM.nextInt(DIGITS.length)];
    }

}
