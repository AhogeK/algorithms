package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 47. 全排列 II
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-11-27 05:11:06
 */
public class PermutationsII {
    List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> path = new ArrayList<>(nums.length);
            for (int num : nums) path.add(num);
            res.add(path);
            return;
        }

        boolean[] usedInCurrentLevel = new boolean[21];

        for (int i = index; i < nums.length; i++) {
            if (usedInCurrentLevel[nums[i] + 10]) continue;

            usedInCurrentLevel[nums[i] + 10] = true;
            swap(nums, index, i);
            dfs(nums, index + 1);
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
