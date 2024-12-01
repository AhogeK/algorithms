package sort.leetcode.select;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author AhogeK ahogek@gmail.com
 * @since 2023-06-29 21:01:43
 */
class BubbleSortTest {

    private final BubbleSort bubbleSort = new BubbleSort();

    @Test
    void test() {
        // 使用类加载器获取文件的输入流
        InputStream inputStream = BubbleSortTest.class.getResourceAsStream("test-array.txt");

        Assertions.assertNotNull(inputStream);

        // 使用 BufferedReader 来读取文件内容
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line = reader.readLine();
            Assertions.assertNotNull(line);
            Assertions.assertFalse(line.isEmpty());
            int[] nums = Stream.of(line.split(",")).mapToInt(Integer::parseInt).toArray();
            int[] nums2 = Arrays.copyOf(nums, nums.length);
            int[] trueResult = Arrays.copyOf(nums, nums.length);
            Arrays.sort(trueResult);
            long start = System.currentTimeMillis();
            int[] result = bubbleSort.sortArray(nums);
            long end = System.currentTimeMillis();
            System.out.println("sortArray 耗时：" + (end - start) + "ms");
            Assertions.assertArrayEquals(trueResult, result);
            start = System.currentTimeMillis();
            int[] result2 = bubbleSort.sortArray2(nums2);
            end = System.currentTimeMillis();
            System.out.println("sortArray2 耗时：" + (end - start) + "ms");
            Assertions.assertArrayEquals(trueResult, result2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
