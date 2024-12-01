package sort.leetcode.select;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStream;

/**
 * @author AhogeK ahogek@gmail.com
 * @since 2023-06-28 14:30:20
 */
class ContainerWithMostWaterTest {
    private final ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();

    @Test
    void test() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = 49;
        Assertions.assertEquals(result, containerWithMostWater.maxArea(height));

        InputStream inputStream = ContainerWithMostWaterTest.class.getResourceAsStream("container-with-most-water-test-array.txt");
        Assertions.assertNotNull(inputStream);
        try (BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(inputStream))) {
            String line = reader.readLine();
            Assertions.assertNotNull(line);
            Assertions.assertFalse(line.isEmpty());
            // 去掉头尾的中括号
            line = line.substring(1, line.length() - 1);
            height = java.util.stream.Stream.of(line.split(",")).mapToInt(Integer::parseInt).toArray();
            // 打印选择排序的耗时
            long start = System.currentTimeMillis();
            int maxArea2Result = containerWithMostWater.maxArea2(height);
            long end = System.currentTimeMillis();
            System.out.println("maxArea2 耗时：" + (end - start) + "ms");
            // 因选择排序在力扣存在超时，所以在这里检测结果是否一致
            Assertions.assertEquals(containerWithMostWater.maxArea(height), maxArea2Result);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

    }
}
