package contest.leetcode.daily.twentyfive.april;

/**
 * 2302. 统计得分小于 K 的子数组数目
 *
 * @author AhogeK
 * @since 2025-04-28 12:52:21
 */
public class CountSubarraysWithScoreLessThanK {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long ans = 0;
        long windowSum = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            windowSum += nums[right];
            // 收缩窗口直至合法
            while (left <= right && windowSum * (right - left + 1) >= k) {
                windowSum -= nums[left];
                left++;
            }
            // 当前 right, 窗口 [left, right] 内的所有[l, right]都合法
            ans += right - left + 1;
        }
        return ans;
    }
}
