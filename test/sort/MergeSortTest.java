package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sort.common.SortingUtil;

/**
 * 归并排序测试
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-02-28 13:52:20
 */
class MergeSortTest {

    @Test
    void caseTest() {
        SortingUtil.testSortingAlgorithms(new MergeSort(), 10_000_000);
    }
}
