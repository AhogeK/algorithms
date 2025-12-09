package backtracking;

import java.util.Arrays;

/**
 * 886. 可能的二分法
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-09 19:57:15
 */
public class PossibleBipartition {
    int[] head, next, to;
    int tot;
    int[] color;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        head = new int[n + 1];
        Arrays.fill(head, -1);
        int m = dislikes.length;
        next = new int[m * 2];
        to = new int[m * 2];
        tot = 0;
        for (int[] d : dislikes) {
            addEdge(d[0], d[1]);
            addEdge(d[1], d[0]);
        }
        color = new int[n + 1];
        for (int i = 1; i <= n; i++)
            if (color[i] == 0 && dfs(i, 1)) return false;
        return true;
    }

    private void addEdge(int u, int v) {
        to[tot] = v;
        next[tot] = head[u];
        head[u] = tot++;
    }

    private boolean dfs(int u, int c) {
        color[u] = c;
        for (int i = head[u]; i != -1; i = next[i]) {
            int v = to[i];
            if ((color[v] == 0 && dfs(v, -c)) || color[v] == c) return true;
        }
        return false;
    }
}
