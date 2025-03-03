package sort.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author AhogeK
 * @since 2025-03-01 23:47:13
 */
class FindMinimumInRotatedArrayIITest {

    @Test
    void test() {
        int[] nums = {1, 3, 5};
        int result = 1;
        Assertions.assertEquals(result, new FindMinimumInRotatedArrayII().findMin(nums));
    }
}
