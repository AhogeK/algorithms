package binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author AhogeK ahogek@gmail.com
 * @since 2023-04-25 10:41:46
 */
class PeakIndexInMountainArrayTest {

    PeakIndexInMountainArray peakIndexInMountainArray = new PeakIndexInMountainArray();

    @Test
    void case1() {
        int[] arr = {24, 69, 100, 99, 79, 78, 67, 36, 26, 19};
        Assertions.assertEquals(2, peakIndexInMountainArray.peakIndexInMountainArray(arr));
    }
}
