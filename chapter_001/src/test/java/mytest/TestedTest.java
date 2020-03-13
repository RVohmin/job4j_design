package mytest;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestedTest {
    @Test
    public void testing() {
        Tested test = new Tested();
        int expected = Tested.method(5);
        assertThat(25, is(expected));
    }
}
