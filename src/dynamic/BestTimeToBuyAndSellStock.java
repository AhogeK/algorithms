package dynamic;

/**
 * 121. 买卖股票的最佳时机
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-02-01 20:55:21
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int best = 0;
        for (int i = 0; i < prices.length; i++) {
            int p = prices[i];
            if (p < minPrice) minPrice = p;
            else {
                int profit = p - minPrice;
                if (profit > best) best = profit;
            }
        }
        return best;
    }
}
