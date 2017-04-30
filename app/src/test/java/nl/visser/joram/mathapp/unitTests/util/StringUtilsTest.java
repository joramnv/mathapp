package nl.visser.joram.mathapp.unitTests.util;

import org.junit.Test;

import static nl.visser.joram.mathapp.util.StringUtils.isBlank;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StringUtilsTest {

    private final static String EMPTY_STRING = "";
    private final static String NOT_EMPTY_OR_BLANK_STRING = " NoT EmPtY ";

    @Test
    public void givenAnEmptyStringWhenIsBlankIsCalledThenIsBlankReturnsTrue() {
        boolean actual = isBlank(EMPTY_STRING);
        assertThat(actual, is(true));
    }

    @Test
    public void givenNullWhenIsBlankIsCalledThenIsBlankReturnsTrue() {
        boolean actual = isBlank(null);
        assertThat(actual, is(true));
    }

    @Test
    public void givenAStringThatIsNotEmptyWhenIsBlankIsCalledThenIsBlankReturnsFalse() {
        boolean actual = isBlank(NOT_EMPTY_OR_BLANK_STRING);
        assertThat(actual, is(false));
    }

}
