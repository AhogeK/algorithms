package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sort.common.GenerateDuplicateArrayStrategy;
import sort.common.GenerateNearlySortedArrayStrategy;
import sort.common.SortingUtil;

/**
 * @author AhogeK
 * @since 2025-03-07 15:53:26
 */
class QuickSortTest {

    @Test
    void test() {
        Assertions.assertDoesNotThrow(() -> SortingUtil.testSortingAlgorithms(new QuickSort(), 10_000_000));
        Assertions.assertDoesNotThrow(() -> SortingUtil.testSortingAlgorithms(new RandomWayQuickSort(), 10_000_000));
        Assertions.assertDoesNotThrow(() -> SortingUtil.testSortingAlgorithms(new MedianOfThreeQuickSort(), 10_000_000));
        Assertions.assertDoesNotThrow(() -> SortingUtil.testSortingAlgorithms(new SpecialMedianOfThreeQuickSort(), 10_000_000));
        Assertions.assertDoesNotThrow(() -> SortingUtil.testSortingAlgorithms(new TwoWayQuickSort(), 10_000_000));
    }

    @Test
    void orderedComparisonSortTest() {
        // 测试在输入数据接近有序的时候，没有实现「随机选择切分元素」的快速排序比归并排序慢很多
        Assertions.assertDoesNotThrow(() -> SortingUtil.compareSortingAlgorithms(
                new GenerateNearlySortedArrayStrategy(20_000), new QuickSort(), new MergeSort())
        );
        // 大量重复元素的数组比较对撞与普通
        Assertions.assertDoesNotThrow(() -> SortingUtil.compareSortingAlgorithms(
                new GenerateDuplicateArrayStrategy(20_000), new QuickSort(), new TwoWayQuickSort())
        );
    }
}
