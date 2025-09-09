package unionfind;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 1584. 连接所有点的最小费用
 *
 * @author AhogeK
 * @since 2025-09-09 02:07:54
 */
public class MinCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int w = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{w, i, j});
            }
        }
        edges.sort(Comparator.comparingInt(a -> a[0]));
        UnionFind uf = new UnionFind(n);
        int total = 0;
        int count = 0;
        for (int[] e : edges) {
            int w = e[0];
            int u = e[1];
            int v = e[2];
            if (uf.union(u, v)) {
                total += w;
                if (++count == n - 1) break;
            }
        }
        return total;
    }

    static class UnionFind {
        int[] parent;
        int[] rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int x, int y) {
            int rx = find(x);
            int ry = find(y);
            if (rx == ry) return false;
            if (rank[rx] < rank[ry]) parent[rx] = ry;
            else if (rank[rx] > rank[ry]) parent[ry] = rx;
            else {
                parent[ry] = rx;
                rank[rx]++;
            }
            return true;
        }
    }
}
