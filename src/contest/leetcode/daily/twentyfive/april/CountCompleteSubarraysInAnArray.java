package contest.leetcode.daily.twentyfive.april;

/**
 * 2799. 统计完全子数组的数目
 *
 * @author AhogeK
 * @since 2025-04-24 07:54:45
 */
public class CountCompleteSubarraysInAnArray {
    public int countCompleteSubarrays(int[] nums) {
        // 统计全局不同元素数
        boolean[] appear = new boolean[2001];
        int n = nums.length, unique = 0;
        for (int x : nums) {
            if (!appear[x]) {
                appear[x] = true;
                unique++;
            }
        }
        int[] count = new int[2001];
        int types = 0, res = 0;
        // 滑动窗口，始终维护所有种类
        for (int left = 0, right = 0; left < n; left++) {
            while (right < n && types < unique) {
                // 通过计数数组更新种类
                if (++count[nums[right]] == 1)
                    types++;
                right++;
            }
            // 满足了窗口条件，那么现在的右端点到最右怎么移动都符合条件
            if (types == unique)
                res += n - right + 1;
            // 因为左端点移动，需要更新种类
            if (--count[nums[left]] == 0)
                types--;
        }
        return res;
    }
}
