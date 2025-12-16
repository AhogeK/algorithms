package backtracking;

/**
 * 529. 扫雷游戏
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-16 09:50:48
 */
public class Minesweeper {
    private int m, n;
    private char[][] b;
    private static final int[] DR = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] DC = {-1, 0, 1, -1, 1, -1, 0, 1};

    public char[][] updateBoard(char[][] board, int[] click) {
        this.b = board;
        this.m = board.length;
        this.n = board[0].length;
        int r = click[0], c = click[1];
        if (b[r][c] == 'M') {
            b[r][c] = 'X';
            return b;
        }
        dfs(r, c);
        return b;
    }

    private void dfs(int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n || b[r][c] != 'E') return;
        int mines = countAdjMines(r, c);
        if (mines > 0) {
            b[r][c] = (char) ('0' + mines);
            return;
        }
        b[r][c] = 'B';
        for (int k = 0; k < 8; k++) dfs(r + DR[k], c + DC[k]);
    }

    private int countAdjMines(int r, int c) {
        int cnt = 0;
        for (int k = 0; k < 8; k++) {
            int nr = r + DR[k], nc = c + DC[k];
            if (nr < 0 || nr >= m || nc < 0 || nc >= n || b[nr][nc] != 'M') continue;
            cnt++;
        }
        return cnt;
    }
}
