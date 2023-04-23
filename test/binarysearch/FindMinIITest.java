package binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author AhogeK ahogek@gmail.com
 * @since 2023-04-23 11:29:29
 */
class FindMinIITest {

    FindMinII findMinII = new FindMinII();

    @Test
    void case1() {
        int[] nums = {2, 2, 2, 0, 1};
        int result = findMinII.findMin(nums);
        Assertions.assertEquals(0, result);
    }
}
