package contest.leetcode.daily.twentyfive.jun;

import java.util.HashMap;
import java.util.Map;

/**
 * 594. 最长和谐子序列
 *
 * @author AhogeK
 * @since 2025-06-30 22:52:53
 */
public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> cnt = HashMap.newHashMap(nums.length);
        for (int x : nums)
            cnt.merge(x, 1, Integer::sum);
        int ans = 0;
        for (Map.Entry<Integer, Integer> e : cnt.entrySet())
            if (cnt.containsKey(e.getKey() + 1))
                ans = Math.max(ans, cnt.get(e.getKey()) + cnt.get(e.getKey() + 1));
        return ans;
    }
}
