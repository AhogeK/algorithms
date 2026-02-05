package dynamic;

/**
 * 123. 买卖股票的最佳时机 III
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-02-05 23:30:57
 */
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        long negInf = Long.MIN_VALUE;
        long buy1 = negInf, sell1 = 0;
        long buy2 = negInf, sell2 = 0;
        for (int p : prices) {
            buy1 = Math.max(buy1, -(long) p);
            sell1 = Math.max(sell1, buy1 + p);
            buy2 = Math.max(buy2, sell1 - p);
            sell2 = Math.max(sell2, buy2 + p);
        }
        return (int) sell2;
    }
}
