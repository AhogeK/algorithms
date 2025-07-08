package unionfind;

/**
 * 547. 省份数量 (quick-union方案, 按秩合并优化)
 *
 * @author AhogeK
 * @since 2025-07-04 15:49:12
 */
public class NumberOfProvincesV3 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, rank, i, j);
                }
            }
        }
        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                provinces++;
            }
        }
        return provinces;
    }

    private void union(int[] parent, int[] rank, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);

        if (rootX == rootY) return;

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootX] = rootY;
            rank[rootY]++;
        }
    }

    private int find(int[] parent, int x) {
        while (x != parent[x]) x = parent[x];
        return x;
    }
}
