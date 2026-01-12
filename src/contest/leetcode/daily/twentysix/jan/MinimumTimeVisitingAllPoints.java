package contest.leetcode.daily.twentysix.jan;

/**
 * 1266. 访问所有点的最小时间
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-01-12 17:19:20
 */
public class MinimumTimeVisitingAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            int x2 = points[i + 1][0];
            int y2 = points[i + 1][1];

            ans += Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2));
        }
        return ans;
    }
}
