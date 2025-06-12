package daily.twentyfive.jun;

/**
 * 3423. 循环数组中相邻元素的最大差值
 *
 * @author AhogeK
 * @since 2025-06-12 17:02:12
 */
public class MaximumDifferenceBetweenAdjacentElementsInACircularArray {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int res = Math.abs(nums[0] - nums[n - 1]);
        for (int i = 0; i < n - 1; i++) {
            res = Math.max(res, Math.abs(nums[i] - nums[i + 1]));
        }
        return res;
    }
}
