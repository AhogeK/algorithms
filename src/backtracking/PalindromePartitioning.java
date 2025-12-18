package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-19 04:50:19
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        boolean[][] pal = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            pal[i][i] = true;
            for (int j = i + 1; j < n; j++)
                if (cs[i] == cs[j])
                    pal[i][j] = (j - i <= 2) || pal[i + 1][j - 1];
        }
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(0, s, pal, path, ans);
        return ans;
    }

    private void dfs(int start, String s, boolean[][] pal, List<String> path, List<List<String>> ans) {
        int n = s.length();
        if (start == n) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int end = start; end < n; end++) {
            if (!pal[start][end]) continue;
            path.add(s.substring(start, end + 1));
            dfs(end + 1, s, pal, path, ans);
            path.removeLast();
        }
    }
}
