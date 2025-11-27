package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 40. 组合总和 II
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-11-28 03:31:08
 */
public class CombinationSumII {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] candidates;
    int[] freq;

    public List<List<Integer>> combinationSum2(int[] originalCandidates, int target) {
        freq = new int[51];
        for (int num : originalCandidates)
            if (num <= target)
                freq[num]++;
        candidates = new int[51];
        int size = 0;
        for (int i = 1; i <= 50; i++)
            if (freq[i] > 0)
                candidates[size++] = i;
        dfs(0, target, size);
        return res;
    }

    private void dfs(int idx, int rest, int size) {
        if (rest == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (idx == size || candidates[idx] > rest) return;
        int val = candidates[idx];
        int count = freq[val];
        dfs(idx + 1, rest, size);
        for (int i = 1; i <= count; i++) {
            int cost = i * val;
            if (rest - cost < 0) break;
            path.add(val);
            dfs(idx + 1, rest - cost, size);
        }
        int currentSize = path.size();
        while (currentSize > 0 && path.get(currentSize - 1) == val) {
            path.remove(currentSize - 1);
            currentSize--;
        }
    }
}
