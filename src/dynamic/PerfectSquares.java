package dynamic;

import java.util.Arrays;

/**
 * 279. 完全平方数
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-27 18:45:43
 */
public class PerfectSquares {
    public int numSquares(int n) {
        int m = (int) Math.sqrt(n);
        int[] squares = new int[m];
        for (int i = 1; i <= m; i++) squares[i - 1] = i * i;
        int large = 10001;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, large);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int sq : squares) {
                if (sq > i) break;
                int cand = dp[i - sq] + 1;
                if (cand < dp[i]) dp[i] = cand;
            }
        }
        return dp[n];
    }
}
