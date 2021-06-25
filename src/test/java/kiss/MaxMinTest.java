package kiss;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
class MaxMinTest {

    @Test
    public void whenMaxNumber() {
        MaxMin maxMin = new MaxMin();
        List<Integer> list = List.of(
                1, 2, 3, 4, 5, 6, 7, 8, 9
        );
        assertThat(maxMin.max(list, Comparator.naturalOrder()), is(9));
    }

    @Test
    public void whenMinNumber() {
        MaxMin maxMin = new MaxMin();
        List<Integer> list = List.of(
                1, 2, 3, 4, 5, 6, 7, 8, 9
        );
        assertThat(maxMin.min(list, Comparator.naturalOrder()), is(1));
    }

}