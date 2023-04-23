package binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author AhogeK ahogek@gmail.com
 * @since 2023-04-23 11:12:24
 */
class FindMinTest {

    private final FindMin findMin = new FindMin();

    @Test
    void case1() {
        int[] nums = {3, 4, 5, 1, 2};
        int result = findMin.findMin(nums);
        Assertions.assertEquals(1, result);
    }
}
