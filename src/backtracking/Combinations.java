package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-11-28 08:41:10
 */
public class Combinations {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    private void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        int needed = k - path.size();
        int limit = n - needed + 1;
        for (int i = startIndex; i <= limit; i++) {
            path.add(i);
            backtracking(n, k, i + 1);
            path.removeLast();
        }
    }
}
