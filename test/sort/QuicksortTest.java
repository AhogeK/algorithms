package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sort.common.SortingUtil;

/**
 * 快速排序测试用例
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-02-01 17:16:30
 */
class QuicksortTest {

    @Test
    void caseOne() {
        Assertions.assertDoesNotThrow(() -> SortingUtil.testSortingAlgorithms(new Quicksort()));
    }
}
