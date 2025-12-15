package backtracking;

/**
 * 695. 岛屿的最大面积
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-15 22:08:18
 */
public class MaxAreaOfIsland {
    private int m, n;
    private int[][] g;

    public int maxAreaOfIsland(int[][] grid) {
        this.g = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        int best = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    int area = dfs(r, c);
                    if (area > best) best = area;
                }
            }
        }
        return best;
    }

    private int dfs(int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n || g[r][c] == 0) return 0;
        g[r][c] = 0;
        int area = 1;
        area += dfs(r + 1, c);
        area += dfs(r - 1, c);
        area += dfs(r, c + 1);
        area += dfs(r, c - 1);
        return area;
    }
}
