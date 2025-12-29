package contest.leetcode.daily.twentyfive.aug;

/**
 * 2348. 全 0 子数组的数目
 *
 * @author AhogeK
 * @since 2025-08-19 09:54:53
 */
public class NumberOfZeroFilledSubarrays {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0;
        int n = nums.length;
        int last = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) last = i;
            res += i - last;
        }
        return res;
    }
}
