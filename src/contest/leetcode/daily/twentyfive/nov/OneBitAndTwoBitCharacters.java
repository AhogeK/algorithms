package contest.leetcode.daily.twentyfive.nov;

/**
 * 717. 1 比特与 2 比特字符
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-11-18 18:31:18
 */
public class OneBitAndTwoBitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int i = 0;
        while (i < n - 1) {
            if (bits[i] == 0) i += 1;
            else i += 2;
        }
        return i == n - 1;
    }
}
