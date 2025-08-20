package daily.twentyfive.aug;

/**
 * 1277. 统计全为 1 的正方形子矩阵
 *
 * @author AhogeK
 * @since 2025-08-20 18:59:36
 */
public class CountSquareSubmatricesWithAllOnes {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] f = new int[m + 1][n + 1];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > 0) {
                    f[i + 1][j + 1] = Math.min(Math.min(f[i][j], f[i][j + 1]), f[i + 1][j]) + 1;
                    ans += f[i + 1][j + 1];
                }
            }
        }
        return ans;
    }
}
