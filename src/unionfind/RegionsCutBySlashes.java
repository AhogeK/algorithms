package unionfind;

/**
 * 959. 由斜杠划分区域
 *
 * @author AhogeK
 * @since 2025-07-23 10:42:08
 */
public class RegionsCutBySlashes {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        UnionFind uf = new UnionFind((n + 1) * (n + 1));
        for (int i = 0; i <= n; i++) {
            // 左边列
            uf.union(0, i * (n + 1));
            // 右边列
            uf.union(0, i * (n + 1) + n);
            // 顶行
            uf.union(0, i);
            // 底行
            uf.union(0, n * (n + 1) + i);
        }
        int regions = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '\\') {
                    // (i,j)-(i+1,j+1)
                    int a = i * (n + 1) + j;
                    int b = (i + 1) * (n + 1) + (j + 1);
                    if (uf.find(a) == uf.find(b)) regions++;
                    uf.union(a, b);
                } else if (c == '/') {
                    // (i+1,j)-(i,j+1)
                    int a = (i + 1) * (n + 1) + j;
                    int b = i * (n + 1) + (j + 1);
                    if (uf.find(a) == uf.find(b)) regions++;
                    uf.union(a, b);
                }
            }
        }
        return regions;
    }

    static class UnionFind {
        int[] parent, rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        public int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(int x, int y) {
            int fx = find(x), fy = find(y);
            if (fx == fy) return;
            if (rank[fx] < rank[fy]) parent[fx] = fy;
            else if (rank[fx] > rank[fy]) parent[fy] = fx;
            else {
                parent[fy] = fx;
                rank[fx]++;
            }
        }
    }
}
