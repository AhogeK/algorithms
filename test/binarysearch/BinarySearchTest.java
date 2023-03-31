package binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 二分查找单元测试
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-03-31 11:12:35
 */
class BinarySearchTest {

    private final BinarySearch binarySearch = new BinarySearch();

    @Test
    void case1() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 5;
        int result = binarySearch.search(nums, target);
        Assertions.assertEquals(4, result);
    }
}
