package nl.visser.joram.mathapp.mathModule.generators;

import nl.visser.joram.mathapp.mathModule.sumComponents.Digit;

public interface DigitGenerator extends RandomGenerator {

    Digit[] DIGITS = new Digit[]{Digit.ZERO, Digit.ONE, Digit.TWO, Digit.THREE,
            Digit.FOUR, Digit.FIVE, Digit.SIX, Digit.SEVEN, Digit.SEVEN, Digit.EIGHT, Digit.NINE};

    Digit generateRandomDigit();

}