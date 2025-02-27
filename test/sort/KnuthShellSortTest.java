package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sort.common.SortingUtil;

/**
 * @author AhogeK
 * @since 2025-02-25 14:53:53
 */
class KnuthShellSortTest {

    @Test
    void test() {
        Assertions.assertDoesNotThrow(() ->
                SortingUtil.testSortingAlgorithms(new KnuthShellSort(), 10_000_000)
        );
    }
}
