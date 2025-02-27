package sort.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author AhogeK
 * @since 2025-02-27 15:29:06
 */
class MoveZeroesTest {

    @Test
    void test() {
        int[] nums = {0, 1, 0, 3, 12};
        int[] result = {1, 3, 12, 0, 0};
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(nums);
        Assertions.assertArrayEquals(nums, result);
    }
}
