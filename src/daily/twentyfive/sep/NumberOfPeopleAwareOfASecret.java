package daily.twentyfive.sep;

/**
 * 2327. 知道秘密的人数
 *
 * @author AhogeK
 * @since 2025-09-09 10:15:37
 */
public class NumberOfPeopleAwareOfASecret {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int mod = 1_000_000_007;
        int[] dp = new int[n + 1];
        int[] pre = new int[n + 1];
        dp[1] = 1;
        pre[1] = 1;
        for (int i = 2; i <= n; i++) {
            int left = Math.max(1, i - forget + 1);
            int right = i - delay;
            if (right >= left)
                dp[i] = (pre[right] - pre[left - 1] + mod) % mod;
            pre[i] = (pre[i - 1] + dp[i]) % mod;
        }
        int ans = 0;
        for (int i = Math.max(1, n - forget + 1); i <= n; i++)
            ans = (ans + dp[i]) % mod;
        return ans;
    }
}
