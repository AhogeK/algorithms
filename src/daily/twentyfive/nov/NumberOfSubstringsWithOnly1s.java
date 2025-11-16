package daily.twentyfive.nov;

/**
 * 1513. 仅含 1 的子串数
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-11-16 18:40:59
 */
public class NumberOfSubstringsWithOnly1s {
    public int numSub(String s) {
        final int MOD = 1_000_000_007;
        char[] cs = s.toCharArray();
        long ans = 0;
        long cnt = 0;
        for (char c : cs) {
            if (c == '1') {
                cnt++;
            } else if (cnt > 0) {
                if ((cnt & 1) == 0) {
                    ans += (cnt / 2) * (cnt + 1);
                } else {
                    ans += cnt * ((cnt + 1) / 2);
                }
                ans %= MOD;
                cnt = 0;
            }
        }
        if (cnt > 0) {
            if ((cnt & 1) == 0) {
                ans += (cnt / 2) * (cnt + 1);
            } else {
                ans += cnt * ((cnt + 1) / 2);
            }
            ans %= MOD;
        }
        return (int) ans;
    }
}
