package dynamic;

/**
 * 309. 买卖股票的最佳时机含冷冻期
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-02-14 19:57:22
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;
        int hold = -prices[0];
        int sold = 0;
        int cool = 0;
        for (int i = 1; i < n; i++) {
            int newHold = Math.max(hold, cool - prices[i]);
            int newSold = hold + prices[i];
            int newCool = Math.max(sold, cool);
            hold = newHold;
            sold = newSold;
            cool = newCool;
        }
        return Math.max(sold, cool);
    }
}
