package nl.visser.joram.mathapp.mathModule.generators.Impl;

import nl.visser.joram.mathapp.mathModule.sumComponents.Digit;
import nl.visser.joram.mathapp.mathModule.generators.DigitGenerator;

public class DigitGeneratorImpl implements DigitGenerator {

    public Digit generateRandomDigit() {
        return DIGITS[RANDOM.nextInt(DIGITS.length)];
    }

}
