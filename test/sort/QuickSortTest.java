package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sort.common.SortingUtil;

/**
 * @author AhogeK
 * @since 2025-03-07 15:53:26
 */
class QuickSortTest {

    @Test
    void test() {
        Assertions.assertDoesNotThrow(() -> SortingUtil.testSortingAlgorithms(new QuickSort(), 10_000_000));
    }
}
