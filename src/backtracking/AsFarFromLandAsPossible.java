package backtracking;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1162. 地图分析
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-16 18:56:42
 */
public class AsFarFromLandAsPossible {
    private static final int[] DR = {1, -1, 0, 0};
    private static final int[] DC = {0, 0, 1, -1};

    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int[][] dist = new int[n][n];
        for (int r = 0; r < n; r++)
            for (int c = 0; c < n; c++)
                dist[r][c] = -1;
        Deque<Integer> q = new ArrayDeque<>();
        int landCnt = 0;
        for (int r = 0; r < n; r++)
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    landCnt++;
                    dist[r][c] = 0;
                    q.addLast(r * n + c);
                }
            }
        if (landCnt == 0 || landCnt == n * n) return -1;
        int ans = -1;
        while (!q.isEmpty()) {
            int pos = q.removeFirst();
            int r = pos / n;
            int c = pos % n;
            for (int k = 0; k < 4; k++) {
                int nr = r + DR[k];
                int nc = c + DC[k];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n || dist[nr][nc] != -1) continue;
                dist[nr][nc] = dist[r][c] + 1;
                q.addLast(nr * n + nc);
                if (grid[nr][nc] == 0 && dist[nr][nc] > ans)
                    ans = dist[nr][nc];
            }
        }
        return ans;
    }
}
