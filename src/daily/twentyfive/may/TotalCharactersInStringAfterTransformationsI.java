package daily.twentyfive.may;

/**
 * 3335. 字符串转换后的长度 I
 *
 * @author AhogeK
 * @since 2025-05-13 18:52:41
 */
public class TotalCharactersInStringAfterTransformationsI {
    private static final int MOD = (int) (1e9 + 7);

    public int lengthAfterTransformations(String s, int t) {
        int n = t + 26;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i <= 25) {
                dp[i] = 1;
            } else {
                dp[i] = (dp[i - 26] + dp[i - 25]) % MOD;
            }
        }
        int res = 0;
        for (char c : s.toCharArray()) {
            res += dp[c - 'a' + t];
            if (res >= MOD) res -= MOD;
        }
        return res;
    }
}
