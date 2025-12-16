package backtracking;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 994. 腐烂的橘子
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-16 10:49:04
 */
public class RottingOranges {
    private static final int[] DR = {1, -1, 0, 0};
    private static final int[] DC = {0, 0, 1, -1};

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Deque<Integer> q = new ArrayDeque<>();
        int fresh = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) fresh++;
                else if (grid[r][c] == 2) q.offer(r * n + c);
            }
        }
        if (fresh == 0) return 0;
        int minutes = 0;
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int pos = q.removeFirst();
                int r = pos / n;
                int c = pos % n;
                for (int k = 0; k < 4; k++) {
                    int nr = r + DR[k];
                    int nc = c + DC[k];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] != 1) continue;
                    grid[nr][nc] = 2;
                    fresh--;
                    q.addLast(nr * n + nc);
                }
            }
            minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }
}
