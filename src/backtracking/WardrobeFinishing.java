package backtracking;

/**
 * LCR 130. 衣橱整理
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-15 05:30:29
 */
public class WardrobeFinishing {
    public int wardrobeFinishing(int m, int n, int cnt) {
        int[] rowSum = new int[m];
        int[] colSum = new int[n];
        for (int i = 0; i < m; i++) rowSum[i] = digitSum(i);
        for (int j = 0; j < n; j++) colSum[j] = digitSum(j);
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, cnt, rowSum, colSum, visited);
    }

    private int dfs(int i, int j, int m, int n, int cnt, int[] rowSum, int[] colSum, boolean[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n) return 0;
        if (visited[i][j]) return 0;
        if (rowSum[i] + colSum[j] > cnt) return 0;
        visited[i][j] = true;
        int res = 1;
        res += dfs(i + 1, j, m, n, cnt, rowSum, colSum, visited);
        res += dfs(i, j + 1, m, n, cnt, rowSum, colSum, visited);
        return res;
    }

    private int digitSum(int x) {
        int s = 0;
        while (x > 0) {
            s += x % 10;
            x /= 10;
        }
        return s;
    }
}
