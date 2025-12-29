package contest.leetcode.daily.twentyfive.nov;

/**
 * 1015. 可被 K 整除的最小整数
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-11-25 17:24:51
 */
public class SmallestIntegerDivisibleByK {
    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) return -1;
        int remainder = 0;
        for (int len = 1; len <= k; len++) {
            remainder = (remainder * 10 + 1) % k;
            if (remainder == 0) return len;
        }
        return -1;
    }
}
