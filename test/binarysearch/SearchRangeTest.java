package binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author AhogeK ahogek@gmail.com
 * @since 2023-04-23 11:04:15
 */
class SearchRangeTest {

    private final SearchRange searchRange = new SearchRange();

    @Test
    void case1() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = searchRange.searchRange(nums, target);
        Assertions.assertEquals(3, result[0]);
        Assertions.assertEquals(4, result[1]);
    }
}
