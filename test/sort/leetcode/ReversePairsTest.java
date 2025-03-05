package sort.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author AhogeK
 * @since 2025-03-05 16:05:33
 */
class ReversePairsTest {

    @Test
    void test() {
        int[] nums = {1, 3, 2, 3, 1};
        int result = 2;
        Assertions.assertEquals(result, new ReversePairs().reversePairs(nums));
    }
}
