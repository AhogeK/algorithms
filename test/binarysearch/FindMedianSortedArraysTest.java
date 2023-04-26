package binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author AhogeK ahogek@gmail.com
 * @since 2023-04-26 12:23:15
 */
class FindMedianSortedArraysTest {

    private final FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();

    @Test
    void case01() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double result = findMedianSortedArrays.findMedianSortedArrays(nums1, nums2);
        Assertions.assertEquals(2.0, result);

        nums1 = new int[]{1, 2};
        nums2 = new int[]{3, 4};
        result = findMedianSortedArrays.findMedianSortedArrays(nums1, nums2);
        Assertions.assertEquals(2.5, result);
    }
}
