package contest.leetcode.daily.twentysix.february;

/**
 * 693. 交替位二进制数
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-02-18 10:09:51
 */
public class BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        int x = n ^ (n >> 1);
        return (x & (x + 1)) == 0;
    }
}
