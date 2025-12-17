package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N 皇后
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-17 21:01:49
 */
public class NQueens {
    private List<List<String>> ans;
    private int n;
    private int all;
    private int[] pos;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.all = (1 << n) - 1;
        this.pos = new int[n];
        this.ans = new ArrayList<>();
        dfs(0, 0, 0, 0);
        return ans;
    }

    private void dfs(int row, int cols, int diag1, int diag2) {
        if (row == n) {
            ans.add(buildBoard());
            return;
        }
        int avail = all & (~(cols | diag1 | diag2));
        while (avail != 0) {
            int bit = avail & -avail;
            avail -= bit;
            int col = Integer.numberOfTrailingZeros(bit);
            pos[row] = col;
            dfs(row + 1, cols | bit, (diag1 | bit) << 1, (diag2 | bit) >> 1);
        }
    }

    private List<String> buildBoard() {
        List<String> board = new ArrayList<>(n);
        for (int r = 0; r < n; r++) {
            char[] row = new char[n];
            for (int c = 0; c < n; c++) row[c] = '.';
            row[pos[r]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
