package contest.leetcode.daily.twentyfive.jun;

import java.util.Arrays;

/**
 * 2099. 找到和最大的长度为 K 的子序列
 *
 * @author AhogeK
 * @since 2025-06-28 22:02:14
 */
public class FindSubsequenceOfLengthKWithTheLargestSum {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[][] vals = new int[n][2];
        for (int i = 0; i < n; ++i) {
            vals[i][0] = i;
            vals[i][1] = nums[i];
        }
        Arrays.sort(vals, (x1, x2) -> Integer.compare(x2[1], x1[1]));
        Arrays.sort(vals, 0, k, (x1, x2) -> Integer.compare(x1[0], x2[0]));
        int[] res = new int[k];
        for (int i = 0; i < k; ++i) {
            res[i] = vals[i][1];
        }
        return res;
    }
}
