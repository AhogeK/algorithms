package contest.leetcode.daily.twentysix.jan;

/**
 * 744. 寻找比目标字母大的最小字母
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-01-31 13:51:06
 */
public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int l = 0, r = n;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (letters[m] <= target) l = m + 1;
            else r = m;
        }
        return l == n ? letters[0] : letters[l];
    }
}
