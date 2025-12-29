package contest.leetcode.daily.twentyfive.april;

import java.util.List;

/**
 * 2845. 统计趣味子数组的数目
 *
 * @author AhogeK
 * @since 2025-04-25 11:03:18
 */
public class CountOfInterestingSubarrays {
    public long countInterestingSubarrays(List<Integer> nums, int module, int k) {
        int n = nums.size();
        // 满足条件元素个数的前缀和
        int pre = 0;
        long ans = 0;
        // 哈希表的容量
        int size = Math.min(module, n + 1);
        int[] map = new int[size];
        map[0] = 1;
        for (int i = 0; i < n; i++) {
            if (nums.get(i) % module == k)
                // i符合条件, 前缀和+1
                pre++;
            int want = ((pre - k) % module + module) % module;
            if (want < size)
                ans += map[want];
            int mod = pre % module;
            if (mod < 0)
                mod += module;
            if (mod < size)
                map[mod]++;
        }
        return ans;
    }
}
