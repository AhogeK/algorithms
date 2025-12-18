package backtracking;

/**
 * 3652. 按策略买卖股票的最佳时机
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-18 19:24:12
 */
public class BestTimeToBuyAndSellStockUsingStrategy {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        int m = k >>> 1;
        long base = 0;
        long sum = 0;
        for (int i = 0; i < m; i++) {
            long p = prices[i];
            long s = strategy[i];
            base += p * s;
            sum += p * (-s);
        }
        for (int i = m; i < k; i++) {
            long p = prices[i];
            long s = strategy[i];
            base += p * s;
            sum += p * (1L - s);
        }
        long best = Math.max(0L, sum);
        for (int i = k; i < n; i++) {
            long p = prices[i];
            long s = strategy[i];
            base += p * s;
            sum += p * (1L - s)
                    - (long) prices[i - m]
                    + (long) prices[i - k] * (long) strategy[i - k];
            if (sum > best) best = sum;
        }
        return base + best;
    }
}
