package dynamic;

import java.util.List;

/**
 * 120. 三角形最小路径和
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-01-24 14:44:44
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        List<Integer> lastRow = triangle.get(n - 1);
        int[] dp = new int[lastRow.size()];
        for (int j = 0; j < lastRow.size(); j++) dp[j] = lastRow.get(j);
        for (int i = n - 2; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j <= i; j++) dp[j] = row.get(j) + Math.min(dp[j], dp[j + 1]);
        }
        return dp[0];
    }
}
