package daily.twentyfive.july;

/**
 * 2044. 统计按位或能得到最大值的子集数目
 *
 * @author AhogeK
 * @since 2025-07-28 16:54:33
 */
public class CountNumberOfMaximumBitwiseOrSubsets {
    int ans;
    int maxOr;

    private void backtrack(int[] nums, int start, int or) {
        int n = nums.length;
        if (or == maxOr) {
            ans += (1 << (n - start));
            return;
        }
        for (int i = start; i < n; i++) {
            backtrack(nums, i + 1, or | nums[i]);
        }
    }

    public int countMaxOrSubsets(int[] nums) {
        maxOr = 0;
        ans = 0;
        for (int num : nums) {
            maxOr |= num;
        }
        backtrack(nums, 0, 0);
        return ans;
    }
}
