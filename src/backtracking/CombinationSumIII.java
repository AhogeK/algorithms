package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-11-30 04:17:09
 */
public class CombinationSumIII {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1, 0);
        return res;
    }

    private void backtracking(int k, int n, int startIndex, int sum) {
        if (sum > n) return;
        if (path.size() == k) {
            if (sum == n) res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backtracking(k, n, i + 1, sum);
            sum -= i;
            path.removeLast();
        }
    }
}
