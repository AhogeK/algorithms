package unionfind;

/**
 * 1319. 连通网络的操作次数
 *
 * @author AhogeK
 * @since 2025-07-20 00:14:34
 */
public class NumberOfOperationsToMakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        UnionFind uf = new UnionFind(n);
        for (int[] edge : connections) {
            uf.union(edge[0], edge[1]);
        }
        // 连通分量数-1 即为最少“插线”次数
        return uf.getCount() - 1;
    }

    // 并查集结构
    static class UnionFind {
        int[] parent;
        int[] rank;
        int count;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            // 已连通
            if (rootX == rootY) return;
            if (rank[rootX] < rank[rootY])
                parent[rootX] = rootY;
            else if (rank[rootX] > rank[rootY])
                parent[rootY] = rootX;
            else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            // 合并后连通分量-1
            count--;
        }

        int getCount() {
            return count;
        }
    }
}
