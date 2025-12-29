package contest.leetcode.daily.twentyfive.may;

/**
 * 2918. 数组的最小相等和
 *
 * @author AhogeK
 * @since 2025-05-11 23:21:18
 */
public class MinimumEqualSumOfTwoArraysAfterReplacingZeros {

    public long minSum(int[] nums1, int[] nums2) {
        long s1 = 0;
        long s2 = 0;
        int c1 = 0;
        int c2 = 0;

        for (int v : nums1) {
            if (v == 0) c1++;
            else s1 += v;
        }

        for (int v : nums2) {
            if (v == 0) c2++;
            else s2 += v;
        }

        s1 += c1;
        s2 += c2;

        if ((c1 == 0 && s2 > s1) || (c2 == 0 && s1 > s2))
            return -1;

        return Math.max(s1, s2);
    }
}
