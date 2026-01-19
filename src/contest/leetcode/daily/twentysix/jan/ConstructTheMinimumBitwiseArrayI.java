package contest.leetcode.daily.twentysix.jan;

import java.util.List;

/**
 * 3314. 构造最小位运算数组 I
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-01-20 06:08:23
 */
public class ConstructTheMinimumBitwiseArrayI {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int val = nums.get(i);
            if (val == 2) ans[i] = -1;
            else {
                int t = (val + 1) & -(val + 1);
                ans[i] = val - (t >> 1);
            }
        }
        return ans;
    }
}
