package dynamic;

/**
 * 122. 买卖股票的最佳时机 II
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-02-01 21:16:53
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) profit += diff;
        }
        return profit;
    }
}
