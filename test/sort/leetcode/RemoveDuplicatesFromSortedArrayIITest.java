package sort.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author AhogeK
 * @since 2025-03-10 17:01:49
 */
class RemoveDuplicatesFromSortedArrayIITest {

    @Test
    void test() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] ans = {1, 1, 2, 2, 3};

        int length = new RemoveDuplicatesFromSortedArrayII().removeDuplicates(nums);

        int[] result = Arrays.copyOfRange(nums, 0, length);

        Assertions.assertArrayEquals(ans, result);
    }
}
