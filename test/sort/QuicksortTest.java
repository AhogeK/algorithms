package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

/**
 * 快速排序测试用例
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-02-01 17:16:30
 */
class QuicksortTest {

    @Test
    void caseOne() throws NoSuchAlgorithmException {
        Quicksort quicksort = new Quicksort();
        int[] nums = {5, 1, 1, 2, 0, 0};
        int[] result = {0, 0, 1, 1, 2, 5};
        Assertions.assertArrayEquals(quicksort.sortArray(nums), result);
    }
}
