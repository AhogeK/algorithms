package contest.leetcode.daily.twentyfive.oct;

import java.util.Arrays;

/**
 * 3397. 执行操作后不同元素的最大数量
 *
 * @author AhogeK
 * @since 2025-10-18 16:55:07
 */
public class MaximumNumberOfDistinctElementsAfterOperations {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        int last = Integer.MIN_VALUE;
        for (int x : nums) {
            int target = Math.max(last + 1, x - k);
            if (target <= x + k) {
                ans++;
                last = target;
            }
        }
        return ans;
    }
}
