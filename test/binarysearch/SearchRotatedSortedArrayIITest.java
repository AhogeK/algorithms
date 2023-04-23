package binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author AhogeK ahogek@gmail.com
 * @since 2023-04-23 11:56:11
 */
public class SearchRotatedSortedArrayIITest {

    SearchRotatedSortedArrayII searchRotatedSortedArrayII = new SearchRotatedSortedArrayII();

    @Test
    void case1() {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 0;
        boolean result = searchRotatedSortedArrayII.search(nums, target);
        Assertions.assertTrue(result);
    }

    @Test
    void case2() {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 3;
        boolean result = searchRotatedSortedArrayII.search(nums, target);
        Assertions.assertFalse(result);
    }
}
