package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-11-28 02:52:29
 */
public class CombinationSum {
    private List<List<Integer>> res;
    private int[] path;
    private int pathLen;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        path = new int[41];
        pathLen = 0;
        res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return res;
    }

    private void dfs(int[] candidates, int target, int start) {
        if (target == 0) {
            List<Integer> list = new ArrayList<>(pathLen);
            for (int i = 0; i < pathLen; i++) list.add(path[i]);
            res.add(list);
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int num = candidates[i];
            if (target < num) break;
            path[pathLen++] = num;
            dfs(candidates, target - num, i);
            pathLen--;
        }
    }
}
