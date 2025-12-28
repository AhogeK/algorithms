package daily.twentyfive.dec;

/**
 * 1351. 统计有序矩阵中的负数
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-28 10:30:55
 */
public class CountNegativeNumbers {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int i = m - 1, j = 0;
        int ans = 0;
        while (i >= 0 && j < n) {
            if (grid[i][j] < 0) {
                ans += n - j;
                i--;
            } else j++;
        }
        return ans;
    }
}
