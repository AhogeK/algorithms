package binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author AhogeK ahogek@gmail.com
 * @since 2023-04-29 18:55:27
 */
class FindBestValueTest {

    private final FindBestValue findBestValue = new FindBestValue();

    @Test
    void case1() {
        int[] arr = {60864, 25176, 27249, 21296, 20204};
        int target = 56803;
        int result = findBestValue.findBestValue(arr, target);
        Assertions.assertEquals(11361, result);
        result = findBestValue.findBestValue2(arr, target);
        Assertions.assertEquals(11361, result);
    }
}
