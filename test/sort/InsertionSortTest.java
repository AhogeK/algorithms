package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 插入排序测试
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-02-01 19:00:46
 */
class InsertionSortTest {

    @Test
    void caseOne() {
        InsertionSort insertionSort = new InsertionSort();
        int[] nums = {5, 1, 1, 2, 0, 0};
        int[] result = {0, 0, 1, 1, 2, 5};
        Assertions.assertArrayEquals(insertionSort.sortArray1(nums), result);
        nums = new int[]{5, 1, 1, 2, 0, 0};
        Assertions.assertArrayEquals(insertionSort.sortArray2(nums), result);
        nums = new int[]{5, 1, 1, 2, 0, 0};
        Assertions.assertArrayEquals(insertionSort.sortArray3(nums), result);
    }
}
