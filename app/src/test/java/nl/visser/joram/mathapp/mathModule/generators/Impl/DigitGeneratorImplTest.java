package nl.visser.joram.mathapp.mathModule.generators.Impl;

import org.junit.Test;

import java.util.Arrays;

import nl.visser.joram.mathapp.mathModule.sumComponents.Digit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DigitGeneratorImplTest {

    private DigitGeneratorImpl digitGeneratorImpl = new DigitGeneratorImpl();

    @Test
    public void whenGenerateRandomDigitIsCalledThenGenerateRandomDigitReturnsAValidDigit() throws Exception {
        Digit randomDigit = digitGeneratorImpl.generateRandomDigit();
        boolean actual = Arrays.asList(DigitGeneratorImpl.DIGITS).contains(randomDigit);
        assertThat(actual, is(true));
    }

}
