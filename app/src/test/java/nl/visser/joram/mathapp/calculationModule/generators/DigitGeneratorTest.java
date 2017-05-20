package nl.visser.joram.mathapp.calculationModule.generators;

import org.junit.Test;

import java.util.Arrays;

import nl.visser.joram.mathapp.calculationModule.Digit;
import nl.visser.joram.mathapp.calculationModule.generators.Impl.DigitGeneratorImpl;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DigitGeneratorTest {

    private DigitGenerator digitGenerator = new DigitGeneratorImpl();

    @Test
    public void whenGenerateRandomDigitIsCalledThenGenerateRandomDigitReturnsAValidDigit() throws Exception {
        Digit randomDigit = digitGenerator.generateRandomDigit();
        boolean actual = Arrays.asList(DigitGenerator.DIGITS).contains(randomDigit);
        assertThat(actual, is(true));
    }

}
