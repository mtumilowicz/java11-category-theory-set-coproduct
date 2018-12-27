import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by mtumilowicz on 2018-12-27.
 */
public class LeftTest {

    private Either left = Either.left(1);

    @Test
    public void getLeft() {
        assertThat(left.getLeft(), is(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void getRight() {
        left.getRight();
    }

    @Test
    public void isLeft() {
        assertTrue(left.isLeft());
    }

    @Test
    public void isRight() {
        assertFalse(left.isRight());
    }
}