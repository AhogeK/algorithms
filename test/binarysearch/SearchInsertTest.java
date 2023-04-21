package binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author AhogeK ahogek@gmail.com
 * @since 2023-04-21 15:35:26
 */
class SearchInsertTest {

    private final SearchInsert searchInsert = new SearchInsert();

    @Test
    void case1() {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        int result = searchInsert.searchInsert(nums, target);
        Assertions.assertEquals(2, result);
        target = 2;
        result = searchInsert.searchInsert(nums, target);
        Assertions.assertEquals(1, result);
        target = 7;
        result = searchInsert.searchInsert(nums, target);
        Assertions.assertEquals(4, result);
    }
}
