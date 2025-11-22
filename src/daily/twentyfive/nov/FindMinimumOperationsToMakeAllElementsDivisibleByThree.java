package daily.twentyfive.nov;

/**
 * 3190. 使所有元素都可以被 3 整除的最少操作数
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-11-22 19:31:51
 */
public class FindMinimumOperationsToMakeAllElementsDivisibleByThree {
    public int minimumOperations(int[] nums) {
        int ans = 0;
        for (int x : nums)
            if (x % 3 == 0) ans++;
        return ans;
    }
}
