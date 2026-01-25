package contest.leetcode.daily.twentysix.jan.twentyfifth;

import java.util.Arrays;

/**
 * 1984. 学生分数的最小差值
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-01-25 13:45:28
 */
public class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (k <= 1) return 0;
        Arrays.sort(nums);
        int best = Integer.MAX_VALUE;
        for (int i = 0, n = nums.length; i + k - 1 < n; i++) {
            int diff = nums[i + k - 1] - nums[i];
            if (diff < best) best = diff;
        }
        return best;
    }
}
