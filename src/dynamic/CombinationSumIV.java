package dynamic;

/**
 * 377. 组合总和 Ⅳ
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-28 10:47:44
 */
public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int s = 1; s <= target; s++) {
            int ways = 0;
            for (int x : nums)
                if (x <= s) ways += dp[s - x];
            dp[s] = ways;
        }
        return dp[target];
    }
}
