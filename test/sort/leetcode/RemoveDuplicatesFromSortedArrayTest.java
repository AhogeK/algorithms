package sort.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author AhogeK
 * @since 2025-03-10 15:44:24
 */
class RemoveDuplicatesFromSortedArrayTest {

    @Test
    void test() {
        int[] nums = {1, 1, 2};
        int[] ans = {1, 2};
        int length = new RemoveDuplicatesFromSortedArray().removeDuplicates(nums);
        int[] result = Arrays.copyOfRange(nums, 0, length);

        Assertions.assertArrayEquals(ans, result);
    }
}
