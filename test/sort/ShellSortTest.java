package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author AhogeK ahogek@gmail.com
 * @since 2023-02-02 13:15:27
 */
class ShellSortTest {

    @Test
    void caseOne() {
        int[] nums = {5, 1, 1, 2, 0, 0};
        int[] result = {0, 0, 1, 1, 2, 5};
        ShellSort shellSort = new ShellSort();
        Assertions.assertArrayEquals(shellSort.sortArray(nums), result);
    }
}
