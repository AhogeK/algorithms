package binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 1443. 收集树上所有苹果的最少时间
 *
 * @author AhogeK
 * @since 2025-09-20 16:44:31
 */
public class MinimumTimeToCollectAllApplesInATree {
    class Solution {
        List<List<Integer>> graph;
        boolean[] visited;

        public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
            graph = new ArrayList<>();
            for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
            for (int[] edge : edges) {
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
            }
            visited = new boolean[n];
            return dfs(0, hasApple);
        }

        private int dfs(int node, List<Boolean> hasApple) {
            visited[node] = true;
            int cost = 0;
            for (int next : graph.get(node)) {
                if (visited[next]) continue;
                int subCost = dfs(next, hasApple);
                if (subCost > 0 || hasApple.get(next)) cost += subCost + 2;
            }
            return cost;
        }
    }
}
