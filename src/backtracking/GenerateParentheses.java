package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-01 10:36:06
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) return res;
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private void backtrack(List<String> res, StringBuilder currentPath, int left, int right, int n) {
        if (currentPath.length() == 2 * n) {
            res.add(currentPath.toString());
            return;
        }
        if (left < n) {
            currentPath.append('(');
            backtrack(res, currentPath, left + 1, right, n);
            currentPath.deleteCharAt(currentPath.length() - 1);
        }
        if (right < left) {
            currentPath.append(')');
            backtrack(res, currentPath, left, right + 1, n);
            currentPath.deleteCharAt(currentPath.length() - 1);
        }
    }
}
