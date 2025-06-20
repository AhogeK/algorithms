package daily.twentyfive.jun;

/**
 * 3443. K 次修改后的最大曼哈顿距离
 *
 * @author AhogeK
 * @since 2025-06-20 19:43:31
 */
public class MaximumManhattanDistanceAfterKChanges {

    public int maxDistance(String s, int k) {
        int max = 0;
        int[] dp = new int[256];
        for (int i = 0; i < s.length(); i++) {
            dp[s.charAt(i)]++;
            int distance = Math.abs(dp['N'] - dp['S']) + Math.abs(dp['E'] - dp['W']);
            int minChange = Math.min(dp['N'], dp['S']) + Math.min(dp['E'], dp['W']);
            int add = (minChange < k) ? minChange * 2 : k * 2;
            max = Math.max(max, distance + add);
        }
        return max;
    }
}
