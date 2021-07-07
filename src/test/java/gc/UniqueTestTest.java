package gc;

import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UniqueTestTest {

    @Test
    public void isEquals() {
        String origin = "My cat eats a mouse and milk";
        String text = "My cat eats milk and a mouse";
        assertThat(UniqueTest.isEquals(origin, text), is(true));
    }

    @Test
    public void isNotEquals() {
        String origin = "My cat eats a mouse";
        String text = "A mouse is eaten by a cat";
        assertThat(UniqueTest.isEquals(origin, text), is(false));
    }

    @Test
    public void isSize() {
        String origin = "Я покупаю";
        String duplicate = "Я покупаю";
        assertTrue(UniqueTest.isSize(origin, duplicate));
    }
}