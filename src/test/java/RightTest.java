import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by mtumilowicz on 2018-12-27.
 */
public class RightTest {

    private Either right = Either.right(1);

    @Test(expected = NoSuchElementException.class)
    public void getLeft() {
        right.getLeft();
    }

    @Test
    public void getRight() {
        assertThat(right.getRight(), is(1));
    }

    @Test
    public void isLeft() {
        assertFalse(right.isLeft());
    }

    @Test
    public void isRight() {
        assertTrue(right.isRight());
    }
}