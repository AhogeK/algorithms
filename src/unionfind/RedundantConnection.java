package unionfind;

/**
 * 684. 冗余连接
 *
 * @author AhogeK
 * @since 2025-07-18 16:34:43
 */
public class RedundantConnection {
    // DSU数据结构
    private int[] parent;
    private int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        rank = new int[n + 1];
        // 初始化
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = i;
        }
        // 遍历每条边，按权检查合并
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            if (!union(a, b)) {
                // 本边使得 a 和 b 已在同一集合，说明成环--返回本边
                return edge;
            }
        }
        // 遍历完所有边，无环--返回空
        return new int[]{};
    }

    /**
     * 按秩合并
     *
     * @param x 点x
     * @param y 点y
     * @return 是否进行了合并
     */
    private boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        // 根节点相同，说明已同属一集合
        if (rootX == rootY) return false;
        // 重视高度，矮树合并到高树
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        return true;
    }

    /**
     * 路径压缩查找祖先
     *
     * @param x 被查点
     * @return 祖先点
     */
    private int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }
}
