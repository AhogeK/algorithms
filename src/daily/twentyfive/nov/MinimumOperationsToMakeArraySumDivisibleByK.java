package daily.twentyfive.nov;

/**
 * 3512. 使数组和能被 K 整除的最少操作次数
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-11-29 11:41:31
 */
public class MinimumOperationsToMakeArraySumDivisibleByK {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;
        return sum % k;
    }
}
