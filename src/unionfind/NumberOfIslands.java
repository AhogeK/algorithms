package unionfind;

/**
 * 200. 岛屿数量
 *
 * @author AhogeK
 * @since 2025-07-23 04:43:23
 */
public class NumberOfIslands {
    private int rows, cols;
    private int[] parent, rank;

    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        parent = new int[rows * cols];
        rank = new int[rows * cols];
        for (int i = 0; i < rows * cols; i++) parent[i] = i;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    // 二维坐标到一维索引的转换
                    int index = i * cols + j;
                    // 上
                    if (i > 0 && grid[i - 1][j] == '1') union(index, (i - 1) * cols + j);
                    // 下
                    if (i < rows - 1 && grid[i + 1][j] == '1') union(index, (i + 1) * cols + j);
                    // 左
                    if (j > 0 && grid[i][j - 1] == '1') union(index, i * cols + j - 1);
                    // 右
                    if (j < cols - 1 && grid[i][j + 1] == '1') union(index, i * cols + j + 1);
                }
            }
        }
        int numIslands = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    int index = i * cols + j;
                    if (parent[index] == index) numIslands++;
                }
            }
        }
        return numIslands;
    }

    private int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) parent[rootX] = rootY;
            else if (rank[rootX] > rank[rootY]) parent[rootY] = rootX;
            else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}
