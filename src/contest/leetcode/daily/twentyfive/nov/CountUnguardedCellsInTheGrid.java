package contest.leetcode.daily.twentyfive.nov;

/**
 * 2257. 统计网格图中没有被保卫的格子数
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-11-02 19:04:14
 */
public class CountUnguardedCellsInTheGrid {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for (int[] g : guards)
            grid[g[0]][g[1]] = 2;
        for (int[] w : walls)
            grid[w[0]][w[1]] = 3;
        int[][] dirs = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] g : guards) {
            for (int[] d : dirs) {
                int x = g[0] + d[0];
                int y = g[1] + d[1];
                while (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] < 2) {
                    grid[x][y] = 1;
                    x += d[0];
                    y += d[1];
                }
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) count++;
            }
        }
        return count;
    }
}
