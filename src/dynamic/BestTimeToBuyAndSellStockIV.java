package dynamic;

/**
 * 188. 买卖股票的最佳时机 IV
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-02-06 23:05:30
 */
public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k <= 0) return 0;
        int n = prices.length;
        int[][] dp = new int[k + 1][2];
        for (int i = 0; i <= k; ++i) dp[i][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            for (int j = k; j >= 1; --j) {
                dp[j][0] = Math.max(dp[j][0], dp[j][1] + prices[i]);
                dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - prices[i]);
            }
        }
        return dp[k][0];
    }
}
