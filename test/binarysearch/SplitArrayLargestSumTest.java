package binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author AhogeK ahogek@gmail.com
 * @since 2023-06-18 21:02:52
 */
class SplitArrayLargestSumTest {

    @Test
    void case1() {
        int[] nums = {7, 2, 5, 10, 8};
        int m = 2;
        SplitArrayLargestSum splitArrayLargestSum = new SplitArrayLargestSum();
        int result = splitArrayLargestSum.splitArray(nums, m);
        Assertions.assertEquals(18, result);
    }
}
