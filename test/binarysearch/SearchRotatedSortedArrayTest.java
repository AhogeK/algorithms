package binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author AhogeK ahogek@gmail.com
 * @since 2023-04-23 11:41:22
 */
class SearchRotatedSortedArrayTest {

    private final SearchRotatedSortedArray searchRotatedSortedArray = new SearchRotatedSortedArray();

    @Test
    void case1() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 5;
        int result = searchRotatedSortedArray.search(nums, target);
        Assertions.assertEquals(1, result);
    }
}
