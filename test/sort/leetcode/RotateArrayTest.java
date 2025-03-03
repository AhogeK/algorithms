package sort.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author AhogeK
 * @since 2025-02-28 18:25:05
 */
class RotateArrayTest {

    @Test
    void test() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        int[] result = {5, 6, 7, 1, 2, 3, 4};

        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate(nums, k);
        Assertions.assertArrayEquals(result, nums);
    }
}
