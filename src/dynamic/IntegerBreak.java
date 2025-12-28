package dynamic;

/**
 * 343. 整数拆分
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-28 10:25:15
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            int best = 0;
            for (int j = 1; j < i; j++) {
                int noSplit = j * (i - j);
                int splitRight = j * dp[i - j];
                best = Math.max(best, Math.max(noSplit, splitRight));
            }
            dp[i] = best;
        }
        return dp[n];
    }
}
