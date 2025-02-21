package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sort.common.*;
import sort.leetcode.select.BubbleSort;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 插入排序测试
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-02-01 19:00:46
 */
class InsertionSortTest {

    @Test
    void caseOne() {
        // 使用类加载器获取文件的输入流
        InputStream inputStream = InsertionSortTest.class.getResourceAsStream("leetcode/select/test-array.txt");

        Assertions.assertNotNull(inputStream);

        InsertionSort insertionSort = new InsertionSort();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line = reader.readLine();
            Assertions.assertNotNull(line);
            Assertions.assertFalse(line.isEmpty());
            int[] nums = Stream.of(line.split(",")).mapToInt(Integer::parseInt).toArray();
            int[] nums2 = Arrays.copyOf(nums, nums.length);
            int[] nums3 = Arrays.copyOf(nums, nums.length);
            int[] nums4 = Arrays.copyOf(nums, nums.length);
            int[] nums5 = Arrays.copyOf(nums, nums.length);
            int[] nums6 = Arrays.copyOf(nums, nums.length);
            int[] trueResult = Arrays.copyOf(nums, nums.length);
            Arrays.sort(trueResult);
            long start = System.currentTimeMillis();
            insertionSort.sortArray(nums);
            Assertions.assertArrayEquals(nums, trueResult);
            long end = System.currentTimeMillis();
            System.out.println("sortArray1 耗时：" + (end - start) + "ms");
            start = System.currentTimeMillis();
            Assertions.assertArrayEquals(insertionSort.sortArray2(nums2), trueResult);
            end = System.currentTimeMillis();
            System.out.println("sortArray2 耗时：" + (end - start) + "ms");
            start = System.currentTimeMillis();
            Assertions.assertArrayEquals(insertionSort.sortArray3(nums3), trueResult);
            end = System.currentTimeMillis();
            System.out.println("sortArray3 耗时：" + (end - start) + "ms");
            start = System.currentTimeMillis();
            Assertions.assertArrayEquals(insertionSort.sortArray4(nums4), trueResult);
            end = System.currentTimeMillis();
            System.out.println("sortArray4 耗时：" + (end - start) + "ms");
            start = System.currentTimeMillis();
            Assertions.assertArrayEquals(insertionSort.sortArray5(nums5), trueResult);
            end = System.currentTimeMillis();
            System.out.println("sortArray5 耗时：" + (end - start) + "ms");
            start = System.currentTimeMillis();
            insertionSort.binaryInsertionSort(nums6);
            Assertions.assertArrayEquals(nums6, trueResult);
            end = System.currentTimeMillis();
            System.out.println("binaryInsertionSort 耗时：" + (end - start) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void exerciseOne() {
        int len = 1000;
        int min = 0;
        int max = 1000;

        IGenerateArrayStrategy randomStrategy = new GenerateRandomArrayStrategy(len, min, max);
        IGenerateArrayStrategy nearlySortedStrategy = new GenerateNearlySortedArrayStrategy(len, min, max, 0.8);
        IGenerateArrayStrategy reverseStrategy = new GenerateReversedArrayStrategy(len, min, max);

        ISortingAlgorithm selectionSort = new SelectionSort();
        SortingUtil.testSortingAlgorithms(selectionSort, randomStrategy);
        SortingUtil.testSortingAlgorithms(selectionSort, nearlySortedStrategy);
        SortingUtil.testSortingAlgorithms(selectionSort, reverseStrategy);

        ISortingAlgorithm bubbleSort = new BubbleSort();
        SortingUtil.testSortingAlgorithms(bubbleSort, randomStrategy);
        SortingUtil.testSortingAlgorithms(bubbleSort, nearlySortedStrategy);
        SortingUtil.testSortingAlgorithms(bubbleSort, reverseStrategy);

        ISortingAlgorithm insertionSort = new InsertionSort();
        SortingUtil.testSortingAlgorithms(insertionSort, randomStrategy);
        SortingUtil.testSortingAlgorithms(insertionSort, nearlySortedStrategy);
        SortingUtil.testSortingAlgorithms(insertionSort, reverseStrategy);

        SortingUtil.compareSortingAlgorithms(randomStrategy, selectionSort, bubbleSort, insertionSort);
    }
}
