package contest.leetcode.daily.twentyfive.april;

import java.util.Arrays;

/**
 * @author AhogeK
 * @since 2025-04-19 09:18:30
 */
public class CountTheNumberOfFairPairs {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        /*
         * 容斥原理 lower <= nums[i] + nums[j] <= upper
         * A: nums[i] + nums[j] <= upper
         * B: nums[i] + nums[j] >= lower -> nums[i] + nums[j] < lower
         *  => |A\B| = |A| - |B|
         */
        return count(nums, upper) - count(nums, lower - 1);
    }

    /**
     * 计算满足 nums[i] + nums[j] <= upper 并且 i < j 的数对数量
     *
     * @param nums  数组
     * @param upper 上限
     * @return 满足条件的数对数量
     */
    private long count(int[] nums, int upper) {
        long res = 0;
        // 双指针
        int j = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            while (j > i && nums[j] > upper - nums[i])
                // 找最大j，与i的插值即为满足条件的数对数量
                j--;
            // 不写也行，因为 j - i = 0
            if (j == i) break;
            res += j - i;
        }
        return res;
    }
}
