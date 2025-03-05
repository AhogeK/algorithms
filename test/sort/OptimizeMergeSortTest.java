package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sort.common.SortingUtil;

/**
 * @author AhogeK
 * @since 2025-03-05 15:24:04
 */
class OptimizeMergeSortTest {

    @Test
    void test() {
        Assertions.assertDoesNotThrow(() -> SortingUtil.testSortingAlgorithms(new OptimizeMergeSort(), 10_000_000));
    }
}
