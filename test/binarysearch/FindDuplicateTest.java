package binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author AhogeK ahogek@gmail.com
 * @since 2023-04-29 18:23:01
 */
class FindDuplicateTest {

    @Test
    void case1() {
        int[] nums = {1, 3, 4, 2, 2};
        int expected = 2;
        int actual = new FindDuplicate().findDuplicate(nums);
        Assertions.assertEquals(expected, actual);
    }
}
