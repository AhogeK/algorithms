package contest.leetcode.daily.twentyfive.aug;

/**
 * 1493. 删掉一个元素以后全为 1 的最长子数组
 *
 * @author AhogeK
 * @since 2025-08-24 21:46:56
 */
public class LongestSubarrayOf1sAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int zeroCount = 0;
        int maxLen = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] == 0) zeroCount++;
            while (zeroCount > 1) {
                if (nums[left] == 0) zeroCount--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen - 1;
    }
}
