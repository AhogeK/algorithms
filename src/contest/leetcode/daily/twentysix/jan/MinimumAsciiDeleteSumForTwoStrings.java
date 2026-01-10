package contest.leetcode.daily.twentysix.jan;

/**
 * 712. 两个字符串的最小ASCII删除和
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-01-10 20:35:35
 */
public class MinimumAsciiDeleteSumForTwoStrings {

    public int minimumDeleteSum(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int m = c1.length;
        int n = c2.length;

        int[] dp = new int[n + 1];

        for (int j = 1; j <= n; j++)
            dp[j] = dp[j - 1] + c2[j - 1];

        for (int i = 1; i <= m; i++) {
            int prev = dp[0];
            dp[0] += c1[i - 1];

            for (int j = 1; j <= n; j++) {
                int temp = dp[j];

                if (c1[i - 1] == c2[j - 1]) dp[j] = prev;
                else dp[j] = Math.min(dp[j] + c1[i - 1], dp[j - 1] + c2[j - 1]);

                prev = temp;
            }
        }
        return dp[n];
    }
}
