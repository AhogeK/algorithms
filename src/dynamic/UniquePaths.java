package dynamic;

import java.util.Arrays;

/**
 * 62. 不同路径
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-29 12:38:00
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
