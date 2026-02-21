package contest.leetcode.daily.twentysix.february;

/**
 * 762. 二进制表示中质数个计算置位
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-02-21 09:50:16
 */
public class PrimeNumberOfSetBitsInBinaryRepresentation {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int x = left; x <= right; x++)
            count += 665772 >> Integer.bitCount(x) & 1;
        return count;
    }
}
