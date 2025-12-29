package contest.leetcode.daily.twentyfive.july;

/**
 * 2411. 按位或最大的最小子数组长度
 *
 * @author AhogeK
 * @since 2025-07-29 17:01:46
 */
public class SmallestSubarraysWithMaximumBitwiseOr {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            ans[i] = 1;
            for (int j = i - 1; j >= 0 && (nums[j] | x) != nums[j]; j--) {
                nums[j] |= x;
                ans[j] = i - j + 1;
            }
        }
        return ans;
    }
}
