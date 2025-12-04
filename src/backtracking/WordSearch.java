package backtracking;

/**
 * 79. 单词搜索
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-04 10:33:40
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        int[] boardCount = new int[128];
        for (char[] row : board) for (char c : row) boardCount[c]++;
        int[] wordCount = new int[128];
        for (char c : w) wordCount[c]++;
        for (int i = 0; i < 128; i++) if (wordCount[i] > boardCount[i]) return false;
        if (boardCount[w[0]] > boardCount[w[w.length - 1]]) reverse(w);
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (board[i][j] == w[0] && dfs(board, i, j, w, 0))
                    return true;
        return false;
    }

    private void reverse(char[] w) {
        int left = 0;
        int right = w.length - 1;
        while (left < right) {
            char temp = w[left];
            w[left] = w[right];
            w[right] = temp;
            left++;
            right--;
        }
    }

    private boolean dfs(char[][] board, int i, int j, char[] w, int k) {
        if (k == w.length) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != w[k]) return false;
        char temp = board[i][j];
        board[i][j] = 0;
        boolean res = dfs(board, i + 1, j, w, k + 1) ||
                      dfs(board, i - 1, j, w, k + 1) ||
                      dfs(board, i, j + 1, w, k + 1) ||
                      dfs(board, i, j - 1, w, k + 1);
        board[i][j] = temp;
        return res;
    }
}
