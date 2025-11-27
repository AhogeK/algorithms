package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-11-28 03:59:53
 */
public class Subsets {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int startIndex) {
        res.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, i + 1);
            path.removeLast();
        }
    }
}
