package backtracking;

/**
 * 1034. 边界着色
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-04 18:50:32
 */
public class ColoringABorder {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int originalColor = grid[row][col];
        if (originalColor == color) return grid;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        dfs(grid, row, col, originalColor, color, visited);
        return grid;
    }

    private void dfs(int[][] grid, int r, int c, int originalColor, int targetColor, boolean[][] visited) {
        visited[r][c] = true;
        int m = grid.length;
        int n = grid[0].length;
        boolean isBorder = false;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr < 0 || nr >= m || nc < 0 || nc >= n) isBorder = true;
            else if (!visited[nr][nc])
                if (grid[nr][nc] == originalColor) dfs(grid, nr, nc, originalColor, targetColor, visited);
                else isBorder = true;
        }
        if (isBorder) grid[r][c] = targetColor;
    }
}
