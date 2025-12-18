package backtracking;

/**
 * 37. 解数独
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-18 23:33:08
 */
public class SudokuSolver {
    private static final int FULL = (1 << 9) - 1;
    private final int[] rowMask = new int[9];
    private final int[] colMask = new int[9];
    private final int[] boxMask = new int[9];
    private final int[] er = new int[81];
    private final int[] ec = new int[81];
    private int emptyCount;

    public void solveSudoku(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.') {
                    er[emptyCount] = r;
                    ec[emptyCount] = c;
                    emptyCount++;
                } else {
                    int d = ch - '1';
                    int bit = 1 << d;
                    int b = (r / 3) * 3 + c / 3;
                    rowMask[r] |= bit;
                    colMask[c] |= bit;
                    boxMask[b] |= bit;
                }
            }
        }
        dfs(board, 0);
    }

    private boolean dfs(char[][] board, int pos) {
        if (pos == emptyCount) return true;
        int best = pos;
        int bestCand = 0;
        int bestCnt = 10;
        for (int i = pos; i < emptyCount; i++) {
            int r = er[i];
            int c = ec[i];
            int b = (r / 3) * 3 + c / 3;
            int cand = candidates(r, c, b);
            int cnt = Integer.bitCount(cand);
            if (cnt < bestCnt) {
                bestCnt = cnt;
                bestCand = cand;
                best = i;
                if (cnt == 1) break;
            }
        }
        if (bestCnt == 0) return false;
        swap(er, pos, best);
        swap(ec, pos, best);
        int r = er[pos];
        int c = ec[pos];
        int b = (r / 3) * 3 + c / 3;
        int cand = (best == pos) ? bestCand : candidates(r, c, b);
        while (cand != 0) {
            int pick = cand & -cand;
            cand -= pick;
            int d = Integer.numberOfTrailingZeros(pick);
            place(board, r, c, b, d, pick);
            if (dfs(board, pos + 1)) return true;
            remove(board, r, c, b, pick);
        }
        swap(er, pos, best);
        swap(ec, pos, best);
        return false;
    }

    private void remove(char[][] board, int r, int c, int b, int bit) {
        board[r][c] = '.';
        rowMask[r] ^= bit;
        colMask[c] ^= bit;
        boxMask[b] ^= bit;
    }

    private void place(char[][] board, int r, int c, int b, int d, int bit) {
        board[r][c] = (char) ('1' + d);
        rowMask[r] |= bit;
        colMask[c] |= bit;
        boxMask[b] |= bit;
    }

    private void swap(int[] a, int i, int j) {
        if (i == j) return;
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private int candidates(int r, int c, int b) {
        int used = rowMask[r] | colMask[c] | boxMask[b];
        return FULL & ~used;
    }
}
