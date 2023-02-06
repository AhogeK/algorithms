package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * 排序测试工具类
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-02-06 18:26:05
 */
class SortUtilTest {

    @Test
    void swapTest() {
        int[] nums = {1, 2, 3};
        SortUtil.swap(nums, 0, 2);
        Assertions.assertArrayEquals(new int[]{3, 2, 1}, nums);
    }

    @Test
    void printArrayTest() {
        int[] nums = {1, 2, 3};
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
        SortUtil.printArray(nums);
        System.out.flush();
        System.setOut(old);
        Assertions.assertEquals("[1, 2, 3]\n", baos.toString());
    }

    @Test
    void generateRandomArrayTest() {
        Assertions.assertDoesNotThrow(() -> {
            int len = 10;
            int min = -10;
            int max = 10;
            int[] randomArray = SortUtil.generateRandomArray(len, min, max);
            SortUtil.printArray(randomArray);
        });
    }

    @Test
    void copyArrayTest() {
        int[] nums = {1, 2, 3};
        int[] newArr = SortUtil.copyArray(nums);
        Assertions.assertArrayEquals(nums, newArr);
        Assertions.assertNotSame(nums, newArr);
    }
}
