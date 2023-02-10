package sort.common;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

/**
 * 排序工具类
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-02-06 18:21:10
 */
public class SortingUtil {

    /**
     * 随机数种子
     */
    public static final Random RANDOM;

    /**
     * 测试方法执行的次数
     */
    private static final int TEST_TIMES = 10;

    /**
     * 将毫秒转化为秒的分母常量
     */
    private static final BigDecimal DIVISOR = new BigDecimal("1000");

    /**
     * 小数点后保留几位有效数
     */
    private static final int SCALE = 8;

    static {
        try {
            RANDOM = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private SortingUtil() {
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
        testSortingAlgorithms(sortingAlgorithm, new GenerateRandomArrayStrategy(len, 0, len - 1));
    }

    /**
     * 测试排序算法正确性、计算排序算法时间
     *
     * @param sortingAlgorithm 自己编写的排序算法实现
     * @param generateArray    生成测试用例数组的策略对象
     */
    public static void testSortingAlgorithms(ISortingAlgorithm sortingAlgorithm, IGenerateArrayStrategy generateArray) {
        System.out.printf("您使用的排序算法是：%s%n", sortingAlgorithm);
        printGenerateArrayFeature(generateArray);
        // 多运行几次，避免编写的算法恰好"蒙混过关"
        List<Long> allTimingList = new ArrayList<>();
        for (int i = 0; i < TEST_TIMES; i++) {
            System.out.printf("生成第 %d 个数组，", i + 1);
            // 根据一定的策略生成测试用例数组
            int[] randomArray = generateArray.generateArray();
            // 生成测试用例数组的拷贝
            int[] randomArrayCopy = SortingUtil.copyArray(randomArray);
            // 将计时逻辑封装到一个函数中，更好的做法是使用动态代理或者过滤器
            long millis = timingSortingAlgorithm(sortingAlgorithm, randomArray);
            allTimingList.add(millis);
            // 使用系统库函数对 randomArrayCopy 进行排序
            Arrays.sort(randomArrayCopy);
            // 逐个比较两个排序以后的数组元素，以验证我们编写的排序算法的正确性
            judgeArrayEquals(randomArray, randomArrayCopy);
        }
        LongSummaryStatistics summaryMillisStatistics = allTimingList.stream().mapToLong(a -> a).summaryStatistics();
        System.out.printf("%d 次计算平均耗时 %s 毫秒", TEST_TIMES, summaryMillisStatistics.getAverage());
    }

    /**
     * 比较排序算法的性能，使用随机生成数组
     *
     * @param sortingAlgorithms 排序算法的实现列表
     */
    public static void compareSortingAlgorithms(ISortingAlgorithm... sortingAlgorithms) {
        compareSortingAlgorithms(new GenerateRandomArrayStrategy(), sortingAlgorithms);
    }

    /**
     * 根据不同的随机策略测试用例，比较不同排序算法的性能
     *
     * @param generateRandomArrayStrategy 以对象的方式传入生成随机数组的策略：完全随机、部分有序、完全逆序、有大量重复元素
     * @param sortingAlgorithms           排序算法的实例列表
     */
    private static void compareSortingAlgorithms(GenerateRandomArrayStrategy generateRandomArrayStrategy,
                                                 ISortingAlgorithm... sortingAlgorithms) {
        System.out.println("排序算法比较：");
        int[] nums = generateRandomArrayStrategy.generateArray();
        printGenerateArrayFeature(generateRandomArrayStrategy);
        for (ISortingAlgorithm sortingAlgorithm : sortingAlgorithms) {
            // 其实第 1 个排序算法没有必要复制数组，目前没有想到更好的写法
            int[] numsCopy = copyArray(nums);
            System.out.printf("%s：%n\t", sortingAlgorithm);
            timingSortingAlgorithm(sortingAlgorithm, numsCopy);
        }
        System.out.println();
    }

    /**
     * 统计排序算法耗时
     *
     * @param sortingAlgorithm 排序算法，传入我们自己编写的排序算法实现
     * @param randomArray      随机生成的待排序数组
     * @return 本次计算的耗时
     */
    private static long timingSortingAlgorithm(ISortingAlgorithm sortingAlgorithm, int[] randomArray) {
        // 使用我们的算法对 nums 进行排序
        Instant startTime = Instant.now();
        sortingAlgorithm.sortArray(randomArray);
        Instant endTime = Instant.now();

        // 以毫秒为单位
        long millis = Duration.between(startTime, endTime).toMillis();
        // 向上取整 用于打印秒
        BigDecimal spendBigDecimal = new BigDecimal(String.valueOf(millis)).divide(DIVISOR, SCALE, RoundingMode.CEILING);
        System.out.printf("耗时 %s 秒 / %d 毫秒。%n", spendBigDecimal, millis);
        return millis;
    }

    /**
     * 输出测试用例数组的特点
     *
     * @param generateArrayStrategy 生成随机数组的策略对象
     */
    private static void printGenerateArrayFeature(IGenerateArrayStrategy generateArrayStrategy) {
        System.out.printf("测试用例特点：%s，规模：%d，最小值：%d，最大值：%d。%n", generateArrayStrategy.getFeature(),
                generateArrayStrategy.getLen(), generateArrayStrategy.getMin(), generateArrayStrategy.getMax());
    }
}
