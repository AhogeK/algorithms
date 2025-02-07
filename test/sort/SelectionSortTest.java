package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 快速排序测试
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-02-01 16:45:07
 */
class SelectionSortTest {

    @Test
    void caseOne() {
        SelectionSort selectionSort = new SelectionSort();
        int[] nums = {5, 1, 1, 2, 0, 0};
        int[] result = {0, 0, 1, 1, 2, 5};
        selectionSort.sortArray(nums);
        Assertions.assertArrayEquals(nums, result);
    }
}
