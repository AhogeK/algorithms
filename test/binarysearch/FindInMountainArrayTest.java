package binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author AhogeK ahogek@gmail.com
 * @since 2023-04-26 12:22:09
 */
class FindInMountainArrayTest {

    private final FindInMountainArray findInMountainArray = new FindInMountainArray();

    @Test
    void case1() {
        int[] arr = {1, 2, 3, 4, 5, 3, 1};
        int target = 3;
        int result = findInMountainArray.findInMountainArray(target, new MountainArrayImpl(arr));
        Assertions.assertEquals(2, result);
    }
}
