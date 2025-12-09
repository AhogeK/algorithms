package backtracking;

/**
 * 785. 判断二分图
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-09 14:41:02
 */
public class IsGraphBipartite {
    private int[] colors;
    private int[][] graph;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        this.colors = new int[n];
        this.graph = graph;
        for (int i = 0; i < n; i++) if (colors[i] == 0 && dfs(i, 1)) return false;
        return true;
    }

    private boolean dfs(int node, int color) {
        colors[node] = color;
        int nextColor = -color;
        for (int neighbor : graph[node])
            if ((colors[neighbor] == 0 && dfs(neighbor, nextColor)) || colors[neighbor] == color) return true;
        return false;
    }
}
