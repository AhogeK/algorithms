package contest.leetcode.daily.twentysix.jan;

import java.util.List;

/**
 * 3315. 构造最小位运算数组 II
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-01-21 13:29:41
 */
public class ConstructTheMinimumBitwiseArrayII {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int val = nums.get(i);
            if (val == 2) ans[i] = -1;
            else {
                int bitToReset = Integer.lowestOneBit(~val) >> 1;
                ans[i] = val - bitToReset;
            }
        }
        return ans;
    }
}
