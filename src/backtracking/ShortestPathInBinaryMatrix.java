package backtracking;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1091. 二进制矩阵中的最短路径
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-16 20:00:11
 */
public class ShortestPathInBinaryMatrix {
    private static final int[] DR = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] DC = {-1, 0, 1, -1, 1, -1, 0, 1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        if (n == 1) return 1;
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(0);
        grid[0][0] = 1;
        int steps = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            steps++;
            for (int i = 0; i < size; i++) {
                int pos = q.removeFirst();
                int r = pos / n;
                int c = pos % n;
                for (int k = 0; k < 8; k++) {
                    int nr = r + DR[k];
                    int nc = c + DC[k];
                    if (nr < 0 || nr >= n || nc < 0 || nc >= n || grid[nr][nc] == 1) continue;
                    if (nr == n - 1 && nc == n - 1) return steps;
                    grid[nr][nc] = 1;
                    q.addLast(nr * n + nc);
                }
            }
        }
        return -1;
    }
}
