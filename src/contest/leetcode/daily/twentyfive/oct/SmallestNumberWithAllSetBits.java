package contest.leetcode.daily.twentyfive.oct;

/**
 * 3370. 仅含置位位的最小整数
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-10-29 20:05:44
 */
public class SmallestNumberWithAllSetBits {
    public int smallestNumber(int n) {
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        return n;
    }
}
