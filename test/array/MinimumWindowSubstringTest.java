package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author AhogeK
 * @since 2025-03-19 17:56:11
 */
class MinimumWindowSubstringTest {

    @Test
    void test() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String ans = "BANC";

        Assertions.assertEquals(ans, new MinimumWindowSubstring().minWindow(s, t));
    }
}
