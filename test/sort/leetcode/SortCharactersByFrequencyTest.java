package sort.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author AhogeK
 * @since 2025-03-13 16:30:44
 */
class SortCharactersByFrequencyTest {

    @Test
    void test() {
        String s = "Aabb";
        String ans = "bbAa";

        Assertions.assertEquals(ans, new SortCharactersByFrequency().frequencySort(s));
    }
}
