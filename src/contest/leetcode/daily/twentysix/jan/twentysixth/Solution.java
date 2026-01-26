package contest.leetcode.daily.twentysix.jan.twentysixth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1200. 最小绝对差
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-01-26 13:35:26
 */
public class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff < minDiff) {
                minDiff = diff;
                ans.clear();
                ans.add(List.of(arr[i - 1], arr[i]));
            } else if (diff == minDiff) ans.add(List.of(arr[i - 1], arr[i]));
        }
        return ans;
    }
}
