package contest.leetcode.daily.twentyfive.july;

/**
 * 3304. 找出第 K 个字符 I
 *
 * @author AhogeK
 * @since 2025-07-03 07:31:36
 */
public class FindTheKThCharacterInStringGameI {
    public char kthCharacter(int k) {
        int ans = 0;
        while (k != 1) {
            int t = 31 - Integer.numberOfLeadingZeros(k);
            if ((1 << t) == k)
                t--;
            k -= 1 << t;
            ans++;
        }
        return (char) ('a' + (ans % 26));
    }
}
