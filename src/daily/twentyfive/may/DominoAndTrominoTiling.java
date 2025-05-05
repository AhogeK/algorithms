package daily.twentyfive.may;

/**
 * 790. 多米诺和托米诺平铺
 *
 * @author AhogeK
 * @since 2025-05-05 17:09:44
 */
public class DominoAndTrominoTiling {

    private static final int MOD = 1_000_000_007;

    public int numTilings(int n) {
        if (n <= 2) return n;

        long[] dp = new long[n + 1];
        long[] gap = new long[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        gap[0] = 0;
        gap[1] = 0;
        gap[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + 2 * gap[i - 1]) % MOD;
            gap[i] = (dp[i - 2] + gap[i - 1]) % MOD;
        }

        return (int) dp[n];
    }
}
