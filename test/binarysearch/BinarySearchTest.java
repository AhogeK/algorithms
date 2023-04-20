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
    private final GuessNumber guessNumber = new GuessNumber();

    /**
     * 思路1二分查找测试
     */
    @Test
    void case1() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 5;
        int result = binarySearch.search(nums, target);
        Assertions.assertEquals(4, result);
    }

    /**
     * 递归二分查找测试
     */
    @Test
    void case2() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 5;
        int result = binarySearch.search2(nums, target);
        Assertions.assertEquals(4, result);
    }

    /**
     * 猜数字测试
     */
    @Test
    void guessNumberTestCase() {
        int n = 100;
        int result = guessNumber.guessNumber(n);
        Assertions.assertNotEquals(-1, result);
    }

    /**
     * 思路2二分查找测试
     */
    @Test
    void case3() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 5;
        int result = binarySearch.search3(nums, target);
        Assertions.assertEquals(4, result);
    }
}
