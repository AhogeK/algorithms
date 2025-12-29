package contest.leetcode.daily.twentyfive.aug;

/**
 * 1780. 判断一个数字是否可以表示成三的幂的和
 *
 * @author AhogeK
 * @since 2025-08-14 02:25:37
 */
public class CheckIfNumberIsASumOfPowersOfThree {
    public boolean checkPowersOfThree(int n) {
        // 10^7 < 3^15，所以最多考虑到3^14
        for (int i = 14; i >= 0; i--) {
            int power = 1;
            for (int j = 0; j < i; j++) power *= 3;
            if (n >= power) n -= power;
        }
        return n == 0;
    }
}
