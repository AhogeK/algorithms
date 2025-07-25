package daily.twentyfive.july;

/**
 * 3487. 删除后的最大子数组元素和
 *
 * @author AhogeK
 * @since 2025-07-25 09:30:37
 */
public class MaximumUniqueSubarraySumAfterDeletion {
    public int maxSum(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int[] cnt = new int[101];
        for (int val : nums) {
            if (val > 0 && cnt[val] == 0) {
                sum += val;
                cnt[val] = 1;
            }
            max = Math.max(max, val);
        }
        return sum == 0 ? max : sum;
    }
}
