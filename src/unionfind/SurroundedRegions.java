package unionfind;

/**
 * 130. 被围绕的区域
 *
 * @author AhogeK
 * @since 2025-07-23 05:10:12
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        int dummy = m * n;
        UnionFind uf = new UnionFind(dummy + 1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    int pos = i * n + j;
                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1) uf.union(pos, dummy);
                    else {
                        // 上下左右
                        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
                        for (int[] d : dirs) {
                            int ni = i + d[0], nj = j + d[1];
                            if (ni >= 0 && ni < m && nj >= 0 && nj < n && board[ni][nj] == 'O') {
                                int npos = ni * n + nj;
                                uf.union(pos, npos);
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    int pos = i * n + j;
                    if (uf.find(pos) != uf.find(dummy)) board[i][j] = 'X';
                }
            }
        }
    }

    static class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int total) {
            parent = new int[total];
            rank = new int[total];
            for (int i = 0; i < total; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
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
