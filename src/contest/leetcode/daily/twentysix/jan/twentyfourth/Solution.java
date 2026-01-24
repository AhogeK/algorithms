package contest.leetcode.daily.twentysix.jan.twentyfourth;

import java.util.Arrays;

/**
 * 1877. 数组中最大数对和的最小值
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-01-24 11:18:24
 */
public class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int sum = nums[i] + nums[j];
            if (sum > ans) ans = sum;
        }
        return ans;
    }
}
