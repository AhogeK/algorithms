package contest.leetcode.daily.twentyfive.july;

/**
 * 3202. 找出有效子序列的最大长度 II
 *
 * @author AhogeK
 * @since 2025-07-17 23:50:02
 */
public class FindTheMaximumLengthOfValidSubsequenceII {
    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k];
        int res = 0;
        for (int num : nums) {
            num %= k;
            for (int prev = 0; prev < k; prev++) {
                dp[prev][num] = dp[num][prev] + 1;
                res = Math.max(res, dp[prev][num]);
            }
        }
        return res;
    }
}
