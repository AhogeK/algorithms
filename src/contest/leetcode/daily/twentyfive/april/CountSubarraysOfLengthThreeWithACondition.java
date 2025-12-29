package contest.leetcode.daily.twentyfive.april;

/**
 * 3392. 统计符合条件长度为 3 的子数组数目
 *
 * @author AhogeK
 * @since 2025-04-27 14:21:36
 */
public class CountSubarraysOfLengthThreeWithACondition {
    public int countSubarrays(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i <= n - 3; i++) {
            int a = nums[i];
            int b = nums[i + 1];
            int c = nums[i + 2];
            if (b == 2 * (a + c))
                count++;
        }
        return count;
    }
}
