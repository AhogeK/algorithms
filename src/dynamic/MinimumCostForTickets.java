package dynamic;

/**
 * 983. 最低票价
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-02-24 12:49:07
 */
public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n + 1];
        int p7 = 0;
        int p30 = 0;
        for (int i = 1; i <= n; i++) {
            int d = days[i - 1];
            while (days[p7] <= d - 7) p7++;
            while (days[p30] <= d - 30) p30++;
            dp[i] = Math.min(dp[i - 1] + costs[0], Math.min(dp[p7] + costs[1], dp[p30] + costs[2]));
        }
        return dp[n];
    }
}
