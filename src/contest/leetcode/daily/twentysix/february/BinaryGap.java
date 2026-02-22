package contest.leetcode.daily.twentysix.february;

/**
 * 868. 二进制间距
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-02-22 20:12:34
 */
public class BinaryGap {
    public int binaryGap(int n) {
        int maxGap = 0;
        int lastPos = Integer.numberOfTrailingZeros(n);
        n &= (n - 1);
        while (n != 0) {
            int currentPos = Integer.numberOfTrailingZeros(n);
            int gap = currentPos - lastPos;
            if (gap > maxGap) maxGap = gap;
            lastPos = currentPos;
            n &= (n - 1);
        }
        return maxGap;
    }
}
