package contest.leetcode.daily.twentysix.february;

import java.util.Arrays;

/**
 * 3634. 使数组平衡的最少移除数目
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-02-06 21:47:15
 */
public class MinimumRemovalsToBalanceArray {
    public int minRemoval(int[] nums, int k) {
        final int n = nums.length;
        if (n <= 1) return 0;
        Arrays.sort(nums);
        if (nums[n - 1] <= (long) nums[0] * (long) k) return 0;
        if (k == 1) {
            int best = 1, run = 1;
            for (int i = 1; i < n; i++) {
                if (nums[i] == nums[i - 1]) run++;
                else {
                    if (run > best) best = run;
                    run = 1;
                }
            }
            if (run > best) best = run;
            return n - best;
        }
        int left = 0;
        long limit = (long) nums[0] * (long) k;
        int best = 1;
        for (int right = 0; right < n; right++) {
            final int ar = nums[right];
            while (ar > limit) limit = (long) nums[++left] * (long) k;
            final int len = right - left + 1;
            if (len > best) best = len;
        }
        return n - best;
    }
}
