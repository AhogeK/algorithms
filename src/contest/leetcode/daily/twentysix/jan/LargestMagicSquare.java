package contest.leetcode.daily.twentysix.jan;

/**
 * 1895. 最大的幻方
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-01-18 14:59:51
 */
public class LargestMagicSquare {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] rowSum = new int[m][n + 1];
        int[][] colSum = new int[m + 1][n];
        int[][] diagSum = new int[m + 1][n + 1];
        int[][] antiSum = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = grid[i][j];
                rowSum[i][j + 1] = rowSum[i][j] + x;
                colSum[i + 1][j] = colSum[i][j] + x;
                diagSum[i + 1][j + 1] = diagSum[i][j] + x;
                antiSum[i + 1][j] = antiSum[i][j + 1] + x;
            }
        }

        boolean[][] isSameColSum = new boolean[m][n];

        for (int k = Math.min(m, n); k > 1; k--) {
            for (int i = k; i <= m; i++) {
                int sameCnt = 1;
                for (int j = 1; j < n; j++) {
                    if (colSum[i][j] - colSum[i - k][j] == colSum[i][j - 1] - colSum[i - k][j - 1]) {
                        sameCnt++;
                    } else {
                        sameCnt = 1;
                    }
                    isSameColSum[i - 1][j] = sameCnt >= k;
                }
            }

            for (int j = k; j <= n; j++) {
                int sum = rowSum[0][j] - rowSum[0][j - k];
                int sameCnt = 1;
                for (int i = 2; i <= m; i++) {
                    int rowS = rowSum[i - 1][j] - rowSum[i - 1][j - k];
                    if (rowS == sum) {
                        sameCnt++;
                        if (sameCnt >= k &&
                                isSameColSum[i - 1][j - 1] &&
                                colSum[i][j - 1] - colSum[i - k][j - 1] == sum &&
                                diagSum[i][j] - diagSum[i - k][j - k] == sum &&
                                antiSum[i][j - k] - antiSum[i - k][j] == sum) {
                            return k;
                        }
                    } else {
                        sum = rowS;
                        sameCnt = 1;
                    }
                }
            }
        }

        return 1;
    }
}
