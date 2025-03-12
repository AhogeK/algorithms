package sort.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author AhogeK
 * @since 2025-03-12 22:08:23
 */
class SortColorsTest {

    @Test
    void test() {
        int[] nums = {2, 0, 2, 1, 1, 0};
        int[] ans = {0, 0, 1, 1, 2, 2};

        new SortColors().sortColors(nums);

        Assertions.assertArrayEquals(ans, nums);
    }
}
