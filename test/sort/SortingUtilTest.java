package sort;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sort.common.SortingUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * 排序测试工具类
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-02-06 18:26:05
 */
class SortingUtilTest {

    private static final Logger julLogger = Logger.getLogger("SortingUtil");

    private final List<LogRecord> logRecords = new ArrayList<>();

    private final Handler testHandler = new Handler() {
        @Override
        public void publish(LogRecord logRecord) {
            logRecords.add(logRecord);
        }

        // 无需刷新：内存操作无缓冲
        @Override
        public void flush() {
        /* 此测试 Handler 直接将日志记录存入内存列表，
           无缓冲机制，因此无需实现 flush 操作 */
        }

        // 无需关闭：未持有任何需要释放的资源
        @Override
        public void close() {
        /* 此 Handler 未打开文件、网络连接等需要关闭的资源，
           因此 close() 为空实现 */
        }
    };

    @BeforeEach
    void setup() {
        julLogger.addHandler(testHandler);  // 添加测试处理器
        julLogger.setLevel(Level.ALL); // 允许 DEBUG 级别
    }

    @AfterEach
    void teardown() {
        julLogger.removeHandler(testHandler); // 清理处理器
        logRecords.clear();
    }

    @Test
    void swapTest() {
        int[] nums = {1, 2, 3};
        SortingUtil.swap(nums, 0, 2);
        Assertions.assertArrayEquals(new int[]{3, 2, 1}, nums);
    }

    @Test
    void printArrayTest() {
        int[] nums = {1, 2, 3};

        SortingUtil.printArray(nums);

        // 断言 1：验证日志记录数量
        Assertions.assertFalse(logRecords.isEmpty(), "日志记录集合不应为空");
        Assertions.assertEquals(1, logRecords.size(), "应只记录一条日志");

        // 断言 2：验证日志内容
        LogRecord logRecord = logRecords.getFirst();
        Assertions.assertAll("日志详情验证",
                () -> Assertions.assertEquals(java.util.logging.Level.INFO, logRecord.getLevel(), "日志级别应为 INFO"),
                () -> Assertions.assertTrue(logRecord.getMessage().contains("1, 2, 3"), "消息应包含数组内容"),
                () -> Assertions.assertNull(logRecord.getThrown(), "不应存在异常信息")
        );
    }

    @Test
    void generateRandomArrayTest() {
        Assertions.assertDoesNotThrow(() -> {
            int len = 10;
            int min = -10;
            int max = 10;
            int[] randomArray = SortingUtil.generateRandomArray(len, min, max);
            SortingUtil.printArray(randomArray);
        });
    }

    @Test
    void copyArrayTest() {
        int[] nums = {1, 2, 3};
        int[] newArr = SortingUtil.copyArray(nums);
        Assertions.assertArrayEquals(nums, newArr);
        Assertions.assertNotSame(nums, newArr);
    }

    @Test
    void judgeArrayEqualsTest() {
        int[] nums1 = {1, 2, 3, 4};
        var ref = new Object() {
            int[] nums2 = {1, 2, 3};
        };
        Assertions.assertThrows(RuntimeException.class, () -> SortingUtil.judgeArrayEquals(nums1, ref.nums2));
        ref.nums2 = new int[]{1, 3, 4, 5};
        Assertions.assertThrows(RuntimeException.class, () -> SortingUtil.judgeArrayEquals(nums1, ref.nums2));
    }
}
