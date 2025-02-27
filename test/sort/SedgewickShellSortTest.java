package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sort.common.SortingUtil;

/**
 * @author AhogeK
 * @since 2025-02-25 15:54:34
 */
class SedgewickShellSortTest {

    @Test
    void test() {
        Assertions.assertDoesNotThrow(() ->
                SortingUtil.testSortingAlgorithms(new SedgewickShellSort(), 10_000_000)
        );
    }
}
