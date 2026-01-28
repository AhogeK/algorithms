package dynamic;

/**
 * 63. 不同路径 II
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-01-24 16:32:46
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid[0].length;

        int[] dp = new int[n];
        dp[0] = (obstacleGrid[0][0] == 1) ? 0 : 1;

        for (int[] row : obstacleGrid) {
            for (int j = 0; j < n; j++) {
                if (row[j] == 1) dp[j] = 0;
                else if (j > 0) dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }
}
