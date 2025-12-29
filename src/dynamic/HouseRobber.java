package dynamic;

/**
 * 198. 打家劫舍
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-29 13:23:22
 */
public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int cur = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}
