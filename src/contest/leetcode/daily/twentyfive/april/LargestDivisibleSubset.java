package contest.leetcode.daily.twentyfive.april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author AhogeK
 * @since 2025-04-06 20:02:12
 */
public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        if (len == 0) return new ArrayList<>();

        Arrays.sort(nums);

        // 动态规划找出最大子集个数，最大子集中的最大整数
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int maxSize = 1;
        int maxVal = nums[0];

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxVal = nums[i];
            }
        }

        // 倒推获得最大子集
        List<Integer> res = new ArrayList<>();

        // 从后往前确保构建的是最大整数子集
        for (int i = len - 1; i >= 0 && maxSize > 0; i--) {
            if (dp[i] == maxSize && maxVal % nums[i] == 0) {
                res.add(nums[i]);
                maxVal = nums[i];
                maxSize--;
            }
        }

        return res;
    }
}
