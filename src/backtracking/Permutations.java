package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-11-17 16:48:53
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>(n);
        boolean[] used = new boolean[n];

        dfs(nums, n, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int n, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (path.size() == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[i]) continue;
            used[i] = true;
            path.add(nums[i]);
            dfs(nums, n, path, used, res);
            path.removeLast();
            used[i] = false;
        }
    }
}
