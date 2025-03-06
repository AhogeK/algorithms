package sort.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author AhogeK
 * @since 2025-03-06 22:01:06
 */
class CountOfSmallerNumbersAfterSelfTest {

    @Test
    void test() {
        int[] nums = {5, 2, 6, 1};
        List<Integer> ans = List.of(2, 1, 1, 0);

        Assertions.assertIterableEquals(ans, new CountOfSmallerNumbersAfterSelf().countSmaller(nums));
        Assertions.assertIterableEquals(ans, new CountOfSmallerNumbersAfterSelfStudy().countSmaller(nums));
    }
}
