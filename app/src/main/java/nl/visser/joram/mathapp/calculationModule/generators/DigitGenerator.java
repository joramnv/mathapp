package nl.visser.joram.mathapp.calculationModule.generators;

import nl.visser.joram.mathapp.calculationModule.Digit;

public interface DigitGenerator extends RandomGenerator {

    Digit[] DIGITS = new Digit[]{Digit.ZERO, Digit.ONE, Digit.TWO, Digit.THREE,
            Digit.FOUR, Digit.FIVE, Digit.SIX, Digit.SEVEN, Digit.SEVEN, Digit.EIGHT, Digit.NINE};

    Digit generateRandomDigit();

}