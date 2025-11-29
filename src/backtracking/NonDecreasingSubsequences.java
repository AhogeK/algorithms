package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 491. 非递减子序列
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-11-30 04:43:15
 */
public class NonDecreasingSubsequences {
    List<List<Integer>> ans = new ArrayList<>();
    int[] temp;

    public List<List<Integer>> findSubsequences(int[] nums) {
        temp = new int[nums.length];
        dfs(0, 0, nums);
        return ans;
    }

    private void dfs(int cur, int len, int[] nums) {
        if (len >= 2) {
            List<Integer> path = new ArrayList<>();
            for (int k = 0; k < len; k++) path.add(temp[k]);
            ans.add(path);
        }
        for (int i = cur; i < nums.length; i++) {
            if ((len > 0 && nums[i] < temp[len - 1]) || isDuplicate(nums, cur, i)) continue;
            temp[len] = nums[i];
            dfs(i + 1, len + 1, nums);
        }
    }

    private boolean isDuplicate(int[] nums, int start, int currIndex) {
        for (int k = start; k < currIndex; k++)
            if (nums[k] == nums[currIndex]) return true;
        return false;
    }
}
