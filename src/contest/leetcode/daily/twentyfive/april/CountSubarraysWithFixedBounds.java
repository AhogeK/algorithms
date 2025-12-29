package contest.leetcode.daily.twentyfive.april;

/**
 * 2444. 统计定界子数组的数目
 *
 * @author AhogeK
 * @since 2025-04-26 13:47:18
 */
public class CountSubarraysWithFixedBounds {

    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        long ans = 0;
        int leftBound = -1, minPos = -1, maxPos = -1;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            // 断点判定，即不在区间内的数
            if (x < minK || x > maxK)
                leftBound = i;
            // 区间内确定minK maxK的位置
            if (x == minK)
                minPos = i;
            if (x == maxK)
                maxPos = i;
            int l = Math.min(minPos, maxPos);
            if (l > leftBound)
                ans += l - leftBound;
        }
        return ans;
    }
}
