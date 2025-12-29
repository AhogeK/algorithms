package contest.leetcode.daily.twentyfive.aug;

/**
 * 326. 3 的幂
 *
 * @author AhogeK
 * @since 2025-08-13 19:23:14
 */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
