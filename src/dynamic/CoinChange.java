package dynamic;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-27 16:53:58
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int inf = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, inf);
        dp[0] = 0;
        for (int x = 1; x <= amount; x++) {
            int best = inf;
            for (int c : coins) {
                if (c <= x) {
                    int prev = dp[x - c];
                    if (prev + 1 < best) best = prev + 1;
                }
            }
            dp[x] = best;
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
