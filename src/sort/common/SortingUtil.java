package sort.common;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.logging.Formatter;
import java.util.logging.*;
import java.util.stream.Collectors;

import static java.util.logging.Level.ALL;

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
    private static final System.Logger logger = System.getLogger("SortingUtil");
    /**
     * 测试方法执行的次数
     */
    private static final int TEST_TIMES = 10;

    /**
     * 将纳秒转化为秒的分母常量
     */
    private static final BigDecimal DIVISOR = new BigDecimal("1000000000");

    /**
     * 将纳秒转化为毫秒的分母常量
     */
    private static final BigDecimal MILLIS_DIVISOR = new BigDecimal("1000000");

    /**
     * 小数点后保留几位有效数
     */
    private static final int SCALE = 8;

    static {
        try {
            RANDOM = SecureRandom.getInstanceStrong();
            Logger julLogger = Logger.getLogger("SortingUtil");
            julLogger.setUseParentHandlers(false);

            // 只移除控制台处理器，保留其他处理器
            Arrays.stream(julLogger.getHandlers())
                    .filter(ConsoleHandler.class::isInstance)
                    .forEach(julLogger::removeHandler);

            ConsoleHandler handler = new ConsoleHandler();
            handler.setFormatter(new CustomFormatter());
            handler.setLevel(ALL);
            julLogger.addHandler(handler);
            julLogger.setLevel(ALL);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SecureRandom.getInstanceStrong() not available", e);
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
        String arrayStr;
        if (nums == null)
            arrayStr = "null";
        else
            arrayStr = Arrays.stream(nums).filter(n -> n != 0).mapToObj(String::valueOf)
                    .collect(Collectors.joining(", ", "[", "]"));
        logger.log(System.Logger.Level.INFO, arrayStr);
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
        System.arraycopy(nums, 0, newArr, 0, nums.length);
        return newArr;
    }

    /**
     * 通过逐个比较的方式判断两个数组是否相等
     *
     * @param nums1 比较数组1
     * @param nums2 比较数组2
     */
    public static void judgeArrayEquals(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            throw new IllegalArgumentException("数组不能为null");
        }
        if (nums1.length != nums2.length) {
            throw new IllegalArgumentException(
                    "数组长度不相等: nums1.length=" + nums1.length + ", nums2.length=" + nums2.length
            );
        }
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] != nums2[i]) {
                throw new IllegalArgumentException(
                        "第 " + i + " 个元素不相等: nums1[" + i + "]=" + nums1[i] + ", nums2[" + i + "]=" + nums2[i]
                );
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

    public static void testSortingAlgorithms(ISortingAlgorithm sortingAlgorithm, int len) {
        testSortingAlgorithms(sortingAlgorithm, new GenerateRandomArrayStrategy(len, 0, len - 1));
    }

    /**
     * 测试排序算法正确性、计算排序算法时间
     *
     * @param sortingAlgorithm 自己编写的排序算法实现
     * @param generateArray    生成测试用例数组的策略对象
     */
    public static void testSortingAlgorithms(ISortingAlgorithm sortingAlgorithm, IGenerateArrayStrategy generateArray) {
        logger.log(System.Logger.Level.INFO, String.format("您使用的排序算法是：%s", sortingAlgorithm));

        // 预热运行：生成数据并排序，触发 JVM 加载类、JIT 编译
        int[] warmUpArray = generateArray.generateArray();
        for (int i = 0; i < 3; i++) { // 预热 3 次
            sortingAlgorithm.sortArray(Arrays.copyOf(warmUpArray, warmUpArray.length));
        }

        printGenerateArrayFeature(generateArray);
        List<Long> allTimingList = new ArrayList<>();
        for (int i = 0; i < TEST_TIMES; i++) {
            logger.log(System.Logger.Level.INFO, String.format("生成第 %d 个数组，", i + 1));
            int[] randomArray = generateArray.generateArray();
            int[] randomArrayCopy = SortingUtil.copyArray(randomArray);
            long nanos = timingSortingAlgorithm(sortingAlgorithm, randomArray);
            allTimingList.add(nanos);
            Arrays.sort(randomArrayCopy);
            judgeArrayEquals(randomArray, randomArrayCopy);
        }
        LongSummaryStatistics summaryMillisStatistics = allTimingList.stream().mapToLong(a -> a).summaryStatistics();
        logger.log(System.Logger.Level.INFO, String.format("%d 次计算平均耗时 %s 纳秒", TEST_TIMES, summaryMillisStatistics.getAverage()));
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
     * @param strategy          生成随机数组的策略对象
     * @param sortingAlgorithms 排序算法的实例列表
     */
    public static void compareSortingAlgorithms(IGenerateArrayStrategy strategy,
                                                ISortingAlgorithm... sortingAlgorithms) {
        logger.log(System.Logger.Level.INFO, "排序算法比较：");
        int[] nums = strategy.generateArray();
        printGenerateArrayFeature(strategy);
        for (ISortingAlgorithm sortingAlgorithm : sortingAlgorithms) {
            int[] numsCopy = copyArray(nums);
            logger.log(System.Logger.Level.INFO, String.format("%s：", sortingAlgorithm));
            timingSortingAlgorithm(sortingAlgorithm, numsCopy);
        }
    }

    /**
     * 统计排序算法耗时
     *
     * @param sortingAlgorithm 排序算法
     * @param randomArray      随机生成的待排序数组
     * @return 本次计算的耗时
     */
    private static long timingSortingAlgorithm(ISortingAlgorithm sortingAlgorithm, int[] randomArray) {
        // 预热
        int[] copy;
        if (randomArray.length >= 100) {
            copy = Arrays.copyOfRange(randomArray, 0, 100);
        } else {
            copy = copyArray(randomArray);
        }
        sortingAlgorithm.sortArray(copy);

        Instant startTime = Instant.now();
        sortingAlgorithm.sortArray(randomArray);
        Instant endTime = Instant.now();

        long nanos = Duration.between(startTime, endTime).toNanos();
        BigDecimal spendBigDecimal = new BigDecimal(String.valueOf(nanos)).divide(DIVISOR, SCALE, RoundingMode.CEILING);
        BigDecimal spendMillisBigDecimal = new BigDecimal(String.valueOf(nanos)).divide(MILLIS_DIVISOR, SCALE, RoundingMode.CEILING);
        logger.log(System.Logger.Level.INFO, String.format("耗时 %s 秒 / %s 毫秒 / %d 纳秒", spendBigDecimal, spendMillisBigDecimal, nanos));
        return nanos;
    }

    /**
     * 输出测试用例数组的特点
     *
     * @param generateArrayStrategy 生成随机数组的策略对象
     */
    private static void printGenerateArrayFeature(IGenerateArrayStrategy generateArrayStrategy) {
        logger.log(System.Logger.Level.INFO, String.format("测试用例特点：%s，规模：%d，最小值：%d，最大值：%d。", generateArrayStrategy.getFeature(),
                generateArrayStrategy.getLen(), generateArrayStrategy.getMin(), generateArrayStrategy.getMax()));
    }
}

class CustomFormatter extends Formatter {

    private static final String BRIGHT_WHITE = "\u001B[97m";

    private static final ColorProfile ANSI_PROFILE = new AnsiColorProfile(
            "\u001B[90m",  // Dark Gray - Time
            "\u001B[36m",  // Cyan - Class Name
            BRIGHT_WHITE,  // Bright White - Message
            "\u001B[0m",   // RESET
            BRIGHT_WHITE,  // Bright White - Level Bracket
            BRIGHT_WHITE   // Bright White - Colon
    );
    private static final ColorProfile NO_COLOR_PROFILE = new NoColorProfile();

    @Override
    public String format(LogRecord logRecord) {
        ColorProfile color = isColorEnabled() ? ANSI_PROFILE : NO_COLOR_PROFILE;
        return buildLogMessage(logRecord, color);
    }

    private String buildLogMessage(LogRecord logRecord, ColorProfile color) {
        return switch (color) {
            case AnsiColorProfile p -> buildAnsiMessage(logRecord, p);
            case NoColorProfile p -> buildPlainMessage(logRecord);
            default -> throw new IllegalStateException("Unexpected value: " + color);
        };
    }

    private String buildAnsiMessage(LogRecord logRecord, AnsiColorProfile color) {
        String levelColor = getLevelColor(logRecord.getLevel());
        String messageColor = getMessageColor(logRecord.getLevel());

        return String.format(
                "%s%tT %s[%s%s%s] %s%s%s:%s %s%s%n",
                color.timeColor(),
                new Date(logRecord.getMillis()),
                color.levelBracketColor(),
                levelColor,
                logRecord.getLevel().getLocalizedName(),
                color.levelBracketColor(),
                color.classNameColor(),
                logRecord.getSourceClassName(),
                color.colonColor(),
                messageColor,
                logRecord.getMessage(),
                color.resetCode()
        );
    }

    private String buildPlainMessage(LogRecord logRecord) {
        return String.format(
                "%tT [%s] %s : %s%n",
                new Date(logRecord.getMillis()),
                logRecord.getLevel().getLocalizedName(),
                logRecord.getSourceClassName(),
                logRecord.getMessage()
        );
    }

    private String getLevelColor(Level level) {
        return switch (level.getName()) {
            case "SEVERE" -> "\u001B[31;1m";
            case "ERROR" -> "\u001B[31m";
            case "WARNING" -> "\u001B[33m";
            case "INFO" -> "\u001B[32m";
            default -> "\u001B[0m";
        };
    }

    private String getMessageColor(Level level) {
        return switch (level.getName()) {
            case "SEVERE", "ERROR" -> "\u001B[31m";
            case "WARNING" -> "\u001B[33m";
            case "INFO" -> "\u001B[32m";
            default -> "\u001B[37m";
        };
    }

    private boolean isColorEnabled() {
        String osName = System.getProperty("os.name");
        return (osName != null && !osName.startsWith("Windows")) || Boolean.getBoolean("color.log.enabled");
    }

    private sealed interface ColorProfile permits AnsiColorProfile, NoColorProfile {
    }

    private record AnsiColorProfile(
            String timeColor,
            String classNameColor,
            String messageColor,
            String resetCode,
            String levelBracketColor,
            String colonColor
    ) implements ColorProfile {
    }

    private record NoColorProfile() implements ColorProfile {
    }
}