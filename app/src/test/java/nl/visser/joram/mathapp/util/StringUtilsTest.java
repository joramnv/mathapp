package nl.visser.joram.mathapp.util;

import org.junit.Before;
import org.junit.Test;

import static nl.visser.joram.mathapp.util.StringUtils.isBlank;
import static org.junit.Assert.*;

public class StringUtilsTest {

    private final static String EMPTY_STRING = "";
    private String randomString;

    @Before
    public void before() {
        randomString = createRandomString();
    }

    @Test
    public void givenAnEmptyStringWhenUsingIsBlankThenIsBlankReturnsTrue() {
        boolean b = isBlank(EMPTY_STRING);
        assertTrue(b);
    }

    @Test
    public void givenNullWhenUsingIsBlankThenIsBlankReturnsTrue() {
        boolean b = isBlank(null);
        assertTrue(b);
    }

    @Test
    public void givenARandomStringWhenUsingIsBlankThenIsBlankReturnsFalse() {
        boolean b = isBlank(randomString);
        assertFalse(b);
    }

    public static String createRandomString() {
        //TODO write nice createRandomString method
        //TODO put the method in some class that would more suit it.
        return "aaa";
    }

}