package nl.visser.joram.mathapp.calculationModule.generators;

import org.junit.Test;

import java.util.Arrays;

import nl.visser.joram.mathapp.calculationModule.Digit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DigitGeneratorTest {

    private static final Digit[] DIGITS = new Digit[]{Digit.ZERO, Digit.ONE, Digit.TWO, Digit.THREE,
            Digit.FOUR, Digit.FIVE, Digit.SIX, Digit.SEVEN, Digit.SEVEN, Digit.EIGHT, Digit.NINE};

    @Test
    public void whenGenerateRandomDigitIsCalledThenGenerateRandomDigitReturnsAValidDigit() throws Exception {
        Digit randomDigit = DigitGenerator.generateRandomDigit();
        boolean actual = Arrays.asList(DIGITS).contains(randomDigit);
        assertThat(actual, is(true));
    }

}
