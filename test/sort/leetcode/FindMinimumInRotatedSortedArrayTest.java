package sort.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author AhogeK
 * @since 2025-03-01 22:24:22
 */
class FindMinimumInRotatedSortedArrayTest {

    @Test
    void test() {
        int[] nums = {3, 4, 5, 1, 2};
        int result = 1;

        Assertions.assertEquals(result, new FindMinimumInRotatedSortedArray().findMin(nums));
    }
}
