package wordwrapkata;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static wordwrapkata.Wrapper.wrap;

/**
 * Tests {@link Wrapper#wrap(String, int)}.
 */
public class WrapperTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void wrapZeroColumn() {
        exception.expect(IllegalArgumentException.class);
        wrap("", 0);
    }

    @Test
    public void wrapNull() {
        assertThat(wrap(null, 10), is(""));
    }

    @Test
    public void wrapEmpty() {
        assertThat(wrap("", 10), is(""));
    }

    @Test
    public void wrapOneShortWord() {
        assertThat(wrap("word", 5), is("word"));
    }

    @Test
    public void wrapTwoWordsLongerThanLimit() {
        assertThat(wrap("word word", 6), is("word\nword"));
    }

    @Test
    public void wrapWordLongerThanLength() {
        assertThat(wrap("longword", 4), is("long\nword"));
    }

    @Test
    public void wrapWordLongerThanTwiceLength() {
        assertThat(wrap("verylongword", 4), is("very\nlong\nword"));
    }

    @Test
    public void wrapThreeWordsJustOverTheLimit() {
        assertThat(wrap("word word word", 11), is("word word\nword"));
    }

    @Test
    public void wrapTwoWordsTheFirstEndingAtTheLimit() {
        assertThat(wrap("word word", 4), is("word\nword"));
    }
}
