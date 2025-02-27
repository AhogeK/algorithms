package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sort.common.SortingUtil;

/**
 * @author AhogeK
 * @since 2025-02-23 12:45:41
 */
class HibbardShellSortTest {

    @Test
    void test() {
        Assertions.assertDoesNotThrow(() ->
                SortingUtil.testSortingAlgorithms(new HibbardShellSort(), 10_000_000));
    }
}
