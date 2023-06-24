package binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author AhogeK ahogek@gmail.com
 * @since 2023-06-24 19:25:20
 */
class XiaozhangCodingPracticePlanTest {

    private final XiaozhangCodingPracticePlan xiaozhangCodingPracticePlan =
            new XiaozhangCodingPracticePlan();

    @Test
    void test() {
        int[] time = {1, 2, 3, 3};
        int m = 2;
        int result = xiaozhangCodingPracticePlan.minTime(time, m);
        Assertions.assertEquals(3, result);
    }
}
