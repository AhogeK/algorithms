package contest.leetcode.daily.twentyfive.jun;

/**
 * 2311. 小于等于 K 的最长二进制子序列
 *
 * @author AhogeK
 * @since 2025-06-26 23:08:42
 */
public class LongestBinarySubsequenceLessThanOrEqualToK {
    public int longestSubsequence(String s, int k) {
        int len = s.length();
        int zeroCnt = 0;
        for (int i = 0; i < len; i++)
            if (s.charAt(i) == '0')
                zeroCnt++;
        int ans = zeroCnt;
        long value = 0;
        int power = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                if (power < 32) {
                    long cur = 1L << power;
                    if (value + cur <= k) {
                        value += cur;
                        ans++;
                    }
                }
                power++;
            } else {
                power++;
            }
            if ((1L << power) > k) break;
        }
        return ans;
    }
}
