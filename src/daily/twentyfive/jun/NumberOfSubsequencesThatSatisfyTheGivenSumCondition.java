package daily.twentyfive.jun;

import java.util.Arrays;

/**
 * 1498. 满足条件的子序列数目
 *
 * @author AhogeK
 * @since 2025-06-29 21:23:41
 */
public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition {
    private static final int MOD = 1_000_000_007;
    private static final int[] pow2 = new int[100_000];
    private static boolean initialized = false;

    private static void init() {
        if (initialized) {
            return;
        }
        initialized = true;

        pow2[0] = 1;
        for (int i = 1; i < pow2.length; i++) {
            pow2[i] = pow2[i - 1] * 2 % MOD;
        }
    }

    public int numSubseq(int[] nums, int target) {
        init();
        Arrays.sort(nums);
        long ans = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                ans += pow2[right - left];
                left++;
            } else {
                right--;
            }
        }
        return (int) (ans % MOD);
    }
}
