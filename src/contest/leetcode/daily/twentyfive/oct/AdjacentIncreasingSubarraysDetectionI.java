package contest.leetcode.daily.twentyfive.oct;

import java.util.List;

/**
 * 3349. 检测相邻递增子数组 I
 *
 * @author AhogeK
 * @since 2025-10-14 16:13:51
 */
public class AdjacentIncreasingSubarraysDetectionI {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int[] len = new int[n];
        len[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums.get(i) < nums.get(i + 1)) {
                len[i] = len[i + 1] + 1;
            } else {
                len[i] = 1;
            }
        }
        for (int i = 0; i <= n - 2 * k; i++) {
            if (len[i] >= k && len[i + k] >= k) {
                return true;
            }
        }
        return false;
    }
}
