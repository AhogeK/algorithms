package daily.twentyfive.jun;

/**
 * 2016. 增量元素之间的最大差值
 *
 * @author AhogeK
 * @since 2025-06-16 21:34:02
 */
public class MaximumDifferenceBetweenIncreasingElements {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int ans = -1;
        int preMin = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > preMin) {
                ans = Math.max(ans, nums[i] - preMin);
            } else {
                preMin = nums[i];
            }
        }
        return ans;
    }
}
