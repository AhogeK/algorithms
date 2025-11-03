package daily.twentyfive.oct;

/**
 * 1578. 使绳子变成彩色的最短时间
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-11-03 21:03:15
 */
public class MinimumTimeToMakeRopeColorful {
    public int minCost(String colors, int[] neededTime) {
        char[] cs = colors.toCharArray();
        int ans = 0;
        int n = cs.length;
        for (int i = 1; i < n; i++) {
            if (cs[i] == cs[i - 1]) {
                ans += Math.min(neededTime[i], neededTime[i - 1]);
                neededTime[i] = Math.max(neededTime[i], neededTime[i - 1]);
            }
        }
        return ans;
    }
}
