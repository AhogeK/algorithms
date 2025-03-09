package sort.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author AhogeK
 * @since 2025-03-09 23:00:55
 */
class KthLargestElementInAnArrayTest {

    @Test
    void test() {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int ans = 5;

        Assertions.assertEquals(ans, new KthLargestElementInAnArray().findKthLargest(nums, k));
    }
}
