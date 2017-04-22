package nl.visser.joram.mathapp.util;

import org.junit.Before;
import org.junit.Test;

import static nl.visser.joram.mathapp.testHelpers.RandomValueGenerator.createRandomString;
import static nl.visser.joram.mathapp.util.StringUtils.isBlank;
import static org.junit.Assert.*;

public class StringUtilsTest {

    private final static String EMPTY_STRING = "";
    private String randomString;

    @Before
    public void setUp() throws Exception {
        randomString = createRandomString();
    }

    @Test
    public void givenAnEmptyStringWhenIsBlankIsCalledThenIsBlankReturnsTrue() {
        boolean b = isBlank(EMPTY_STRING);
        assertTrue(b);
    }

    @Test
    public void givenNullWhenIsBlankIsCalledThenIsBlankReturnsTrue() {
        boolean b = isBlank(null);
        assertTrue(b);
    }

    @Test
    public void givenARandomStringWhenIsBlankIsCalledThenIsBlankReturnsFalse() {
        boolean b = isBlank(randomString);
        assertFalse(b);
    }

}
