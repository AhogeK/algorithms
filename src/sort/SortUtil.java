package sort;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
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
    public static int[] generateRandomArray(Integer len, Integer min, Integer max) {
        if (len == null) {
            len = 1_000;
        }
        if (len <= 0) {
            throw new IllegalArgumentException("Invalid len: " + len);
        }
        if (min == null) {
            min = 0;
        }
        if (max == null) {
            max = 1_000;
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

    /**
     * 通过逐个比较的方式判断两个数组是否相等
     *
     * @param nums1 比较数组1
     * @param nums2 比较数组2
     */
    public static void judgeArrayEquals(int[] nums1, int[] nums2) {
        if (nums1.length != nums2.length) {
            throw new RuntimeException("两个数组的不想等！");
        }
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] != nums2[i]) {
                throw new RuntimeException("第" + i + "个元素不相等！");
            }
        }
    }

    /**
     * 测试排序算法正确性、计算排序算法时间
     *
     * @param sortingAlgorithm 自己编写的排序算法实现
     */
    public static void testSortingAlgorithms(ISortingAlgorithm sortingAlgorithm) {
        int len = 1_000;
        int[] nums = generateRandomArray(len, 0, len);
        int[] checkNums = copyArray(nums);
        Instant startTime = Instant.now();
        sortingAlgorithm.sortArray(nums);
        Instant endTime = Instant.now();
        long millis = Duration.between(startTime, endTime).toMillis();
        // 向上取整
        System.out.printf("耗时 %d 毫秒。\n", millis);
        BigDecimal second = new BigDecimal(String.valueOf(millis)).divide(new BigDecimal(1000), 8,
                RoundingMode.CEILING);
        System.out.printf("耗时 %s 秒。\n", second);
        Arrays.sort(checkNums);
        if (!Arrays.equals(checkNums, nums)) {
            System.out.println("结果:");
            printArray(nums);
            System.out.println("正确结果:");
            printArray(checkNums);
            throw new RuntimeException("算法错误");
        }
    }
}
