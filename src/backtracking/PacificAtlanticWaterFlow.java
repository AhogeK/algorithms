package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 417. 太平洋大西洋水流问题
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-04 14:15:58
 */
public class PacificAtlanticWaterFlow {
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) return result;
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, pacific, heights[i][0]);
            dfs(heights, i, n - 1, atlantic, heights[i][n - 1]);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, 0, j, pacific, heights[0][j]);
            dfs(heights, m - 1, j, atlantic, heights[m - 1][j]);
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (pacific[i][j] && atlantic[i][j])
                    result.add(List.of(i, j));
        return result;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] visited, int prevHeight) {
        if (r < 0 || r >= heights.length || c < 0 || c >= heights[0].length || visited[r][c] || heights[r][c] < prevHeight)
            return;
        visited[r][c] = true;
        for (int[] dir : DIRS) {
            int nextR = r + dir[0];
            int nextC = c + dir[1];
            dfs(heights, nextR, nextC, visited, heights[r][c]);
        }
    }
}
