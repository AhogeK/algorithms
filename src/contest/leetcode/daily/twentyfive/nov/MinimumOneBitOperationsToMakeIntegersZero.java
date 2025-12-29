package contest.leetcode.daily.twentyfive.nov;

/**
 * 1611. 使整数变为 0 的最少操作次数
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-11-08 14:12:54
 */
public class MinimumOneBitOperationsToMakeIntegersZero {
    public int minimumOneBitOperations(int n) {
        if (n == 0) {
            return 0;
        }

        int k = bitLen(n);
        return (1 << k) - 1 - minimumOneBitOperations(n - (1 << k - 1));
    }

    private int bitLen(int n) {
        int len = 0;
        while (n > 0) {
            len++;
            n >>= 1;
        }

        return len;
    }
}
