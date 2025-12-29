package contest.leetcode.daily.twentyfive.sep;

import java.util.List;

/**
 * 120. 三角形最小路径和
 *
 * @author AhogeK
 * @since 2025-09-25 19:36:36
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++)
            dp[i] = triangle.get(n - 1).get(i);
        for (int i = n - 2; i >= 0; i--)
            for (int j = 0; j <= i; j++)
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
        return dp[0];
    }
}
