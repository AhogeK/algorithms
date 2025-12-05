package backtracking;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 279. 完全平方数
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-05 10:21:11
 */
public class PerfectSquares {
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        boolean[] visited = new boolean[n + 1];
        visited[n] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int j = 1; j * j <= cur; j++) {
                    int nextVal = cur - j * j;
                    if (nextVal == 0) return level;
                    if (!visited[nextVal]) {
                        queue.offer(nextVal);
                        visited[nextVal] = true;
                    }
                }
            }
        }
        return level;
    }
}
