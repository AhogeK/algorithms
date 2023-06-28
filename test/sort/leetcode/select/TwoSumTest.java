package sort.leetcode.select;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author AhogeK ahogek@gmail.com
 * @since 2023-06-28 11:25:09
 */
class TwoSumTest {

    private final TwoSum twoSum = new TwoSum();

    @Test
    void test() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = new int[]{0, 1};
        Assertions.assertArrayEquals(result, twoSum.twoSum(nums, target));
    }
}
