package daily.twentyfive.nov;

/**
 * 2536. 子矩阵元素加 1
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-11-14 16:08:54
 */
public class IncrementSubmatricesByOne {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] d = new int[n + 1][n + 1];
        for (int[] q : queries) {
            d[q[0]][q[1]]++;
            d[q[0]][q[3] + 1]--;
            d[q[2] + 1][q[1]]--;
            d[q[2] + 1][q[3] + 1]++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                d[i][j] += d[i][j - 1];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] += d[i - 1][j];
            }
        }
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(d[i], 0, ans[i], 0, n);
        }
        return ans;
    }
}
