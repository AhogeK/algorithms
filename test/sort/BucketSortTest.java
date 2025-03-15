package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sort.common.SortingUtil;

/**
 * @author AhogeK
 * @since 2025-03-15 16:43:35
 */
class BucketSortTest {

    @Test
    void test() {
        Assertions.assertDoesNotThrow(() -> SortingUtil.testSortingAlgorithms(new BucketSort(), 100_000));
    }
}
