package contest.leetcode.daily.twentyfive.aug;

/**
 * 3446. 按对角线进行矩阵排序
 *
 * @author AhogeK
 * @since 2025-08-28 20:00:44
 */
public class SortMatrixByDiagonals {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        if (n == 1) return grid;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n - 1 - i; j++) {
                for (int k = i, y = 0; k < n - 1 - j; k++, y++) {
                    if (grid[k][y] < grid[k + 1][y + 1]) {
                        int temp = grid[k][y];
                        grid[k][y] = grid[k + 1][y + 1];
                        grid[k + 1][y + 1] = temp;
                    }
                }
            }
        }
        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                for (int k = i, x = 0; k < n - 1 - j; k++, x++) {
                    if (grid[x][k] > grid[x + 1][k + 1]) {
                        int temp = grid[x][k];
                        grid[x][k] = grid[x + 1][k + 1];
                        grid[x + 1][k + 1] = temp;
                    }
                }
            }
        }
        return grid;
    }
}
