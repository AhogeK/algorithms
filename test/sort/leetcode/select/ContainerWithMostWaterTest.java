package sort.leetcode.select;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
    }
}
