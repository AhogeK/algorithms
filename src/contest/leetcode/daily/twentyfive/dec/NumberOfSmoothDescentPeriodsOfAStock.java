package contest.leetcode.daily.twentyfive.dec;

/**
 * 2110. 股票平滑下跌阶段的数目
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-15 05:05:36
 */
public class NumberOfSmoothDescentPeriodsOfAStock {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long ans = 1;
        long len = 1;
        for (int i = 1; i < n; i++) {
            if (prices[i - 1] - prices[i] == 1) len++;
            else len = 1;
            ans += len;
        }
        return ans;
    }
}
