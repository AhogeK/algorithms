package contest.leetcode.daily.twentyfive.dec;

import java.util.Arrays;

/**
 * 3573. 买卖股票的最佳时机 V
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-17 17:58:57
 */
public class BestTimeToBuyAndSellStockV {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        final long NEG = Long.MIN_VALUE / 4;
        long[] dp0 = new long[k + 1];
        long[] dpL = new long[k + 1];
        long[] dpS = new long[k + 1];
        Arrays.fill(dpL, NEG);
        Arrays.fill(dpS, NEG);
        long p0 = prices[0];
        for (int j = 1; j <= k; j++) {
            dpL[j] = -p0;
            dpS[j] = p0;
        }
        for (int i = 1; i < n; i++) {
            long p = prices[i];
            for (int j = k; j >= 1; j--) {
                long best0 = dp0[j];
                if (dpL[j] != NEG) best0 = Math.max(best0, dpL[j] + p);
                if (dpS[j] != NEG) best0 = Math.max(best0, dpS[j] - p);
                dp0[j] = best0;
                dpL[j] = Math.max(dpL[j], dp0[j - 1] - p);
                dpS[j] = Math.max(dpS[j], dp0[j - 1] + p);
            }
        }
        return dp0[k];
    }
}
