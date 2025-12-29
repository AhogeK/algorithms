package contest.leetcode.daily.twentyfive.july;

/**
 * 2683. 相邻值的按位异或
 *
 * @author AhogeK
 * @since 2025-07-31 15:07:08
 */
public class NeighboringBitwiseXor {
    public boolean doesValidArrayExist(int[] derived) {
        int xor = 0;
        for (int x : derived)
            xor ^= x;
        return xor == 0;
    }
}
