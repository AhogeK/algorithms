package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sort.common.GenerateRandomArrayStrategy;
import sort.common.SortingUtil;

/**
 * @author AhogeK
 * @since 2025-02-27 09:16:40
 */
class CiuraShellSortTest {

    @Test
    void test() {
        Assertions.assertDoesNotThrow(() ->
                SortingUtil.testSortingAlgorithms(new CiuraShellSort(), 1_000_000)
        );
    }

    @Test
    void test2() {
        Assertions.assertDoesNotThrow(() ->
                SortingUtil.compareSortingAlgorithms(new GenerateRandomArrayStrategy(1_000_000),
                        new SedgewickShellSort(), new CiuraShellSort())
        );
    }
}
