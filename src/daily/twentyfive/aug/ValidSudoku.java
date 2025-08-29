package daily.twentyfive.aug;

/**
 * 36. 有效的数独
 *
 * @author AhogeK
 * @since 2025-08-30 00:45:03
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                int num = c - '1';
                int boxId = i / 3 * 3 + j / 3;
                if (row[i][num] || col[j][num] || box[boxId][num]) return false;
                row[i][num] = col[j][num] = box[boxId][num] = true;
            }
        }
        return true;
    }
}
