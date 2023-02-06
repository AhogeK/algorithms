package sort;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * 排序工具类
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-02-06 18:21:10
 */
public class SortUtil {

    private static final Random RANDOM;

    static {
        try {
            RANDOM = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private SortUtil() {
        throw new IllegalStateException("Utility Class");
    }

    /**
     * 交换数组中的两个索引位置的元素
     *
     * @param nums   数组
     * @param index1 索引1
     * @param index2 索引2
     */
    public static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    /**
     * 打印数组
     *
     * @param nums 被打印的数组
     */
    public static void printArray(int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i != nums.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    /**
     * 生成随机数组
     *
     * @param len 数组长度
     * @param min 数组中的最小值
     * @param max 数组中的最大值
     * @return 生成的随机数组
     */
    public static int[] generateRandomArray(int len, int min, int max) {
        if (len <= 0) {
            throw new IllegalArgumentException("Invalid len: " + len);
        }
        if (min > max) {
            throw new IllegalArgumentException("Invalid min max, min need less equals max: " + len + max);
        }
        int[] randomArray = new int[len];
        for (int i = 0; i < len; i++) {
            randomArray[i] = min + RANDOM.nextInt(max - min + 1);
        }
        return randomArray;
    }

    /**
     * 拷贝数组
     *
     * @param nums 待拷贝的数组
     * @return 被拷贝的新数组
     */
    public static int[] copyArray(int[] nums) {
        int[] newArr = new int[nums.length];
        /*
          Java 可以使用

          System.arraycopy(nums, 0, newArr, 0, len)
         */
        for (int i = 0; i < nums.length; i++) {
            newArr[i] = nums[i];
        }
        return newArr;
    }
}
