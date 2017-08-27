package nl.visser.joram.mathapp.util;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StringUtilsTest {

    private final static String EMPTY_STRING = "";
    private final static String NOT_EMPTY_OR_BLANK_STRING = " NoT EmPtY ";

    private StringUtils stringUtils = new StringUtils();

    @Test
    public void givenAnEmptyStringWhenIsBlankIsCalledThenIsBlankReturnsTrue() {
        boolean actual = stringUtils.isBlank(EMPTY_STRING);
        assertThat(actual, is(true));
    }

    @Test
    public void givenNullWhenIsBlankIsCalledThenIsBlankReturnsTrue() {
        boolean actual = stringUtils.isBlank(null);
        assertThat(actual, is(true));
    }

    @Test
    public void givenAStringThatIsNotEmptyWhenIsBlankIsCalledThenIsBlankReturnsFalse() {
        boolean actual = stringUtils.isBlank(NOT_EMPTY_OR_BLANK_STRING);
        assertThat(actual, is(false));
    }

}
