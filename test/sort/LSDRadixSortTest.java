package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sort.common.SortingUtil;

/**
 * @author AhogeK
 * @since 2025-03-14 16:58:08
 */
class LSDRadixSortTest {

    @Test
    void test() {
        Assertions.assertDoesNotThrow(() -> SortingUtil.testSortingAlgorithms(new LSDRadixSort(), 1000_000));
    }
}
