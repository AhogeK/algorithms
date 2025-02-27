package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sort.common.SortingUtil;

/**
 * @author AhogeK ahogek@gmail.com
 * @since 2023-02-02 13:15:27
 */
class ShellSortTest {

    @Test
    void caseOne() {
        Assertions.assertDoesNotThrow(() -> SortingUtil.testSortingAlgorithms(new ShellSort(), 1_000_000));
    }
}
