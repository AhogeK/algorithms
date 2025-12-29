package contest.leetcode.daily.twentyfive.sep;

/**
 * 2749. 得到整数零需要执行的最少操作数
 *
 * @author AhogeK
 * @since 2025-09-05 05:38:14
 */
public class MinimumOperationsToMakeTheIntegerZero {
    public int makeTheIntegerZero(int num1, int num2) {
        for (int k = 1; k <= 60; k++) {
            long x = num1 - (long) k * num2;
            if (x < k) break;
            int cnt = Long.bitCount(x);
            if (cnt <= k) return k;
        }
        return -1;
    }
}
