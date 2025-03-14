package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sort.common.SortingUtil;

/**
 * @author AhogeK
 * @since 2025-03-14 14:48:48
 */
class CountingSortTest {

    @Test
    void test() {
        Assertions.assertDoesNotThrow(() -> SortingUtil.testSortingAlgorithms(new CountingSort(), 100_000));
    }
}
