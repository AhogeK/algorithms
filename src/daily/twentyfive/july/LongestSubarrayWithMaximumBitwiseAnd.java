package daily.twentyfive.july;

/**
 * 2419. 按位与最大的最长子数组
 *
 * @author AhogeK
 * @since 2025-07-30 15:09:46
 */
public class LongestSubarrayWithMaximumBitwiseAnd {
    public int longestSubarray(int[] nums) {
        int maxNum = 0;
        for (int x : nums)
            if (x > maxNum) maxNum = x;
        int ans = 0;
        int cur = 0;
        for (int x : nums) {
            if (x == maxNum) {
                cur++;
                if (cur > ans) ans = cur;
            } else {
                cur = 0;
            }
        }
        return ans;
    }
}
