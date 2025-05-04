package daily.twentyfive.may;

/**
 * 1128. 等价多米诺骨牌对的数量
 *
 * @author AhogeK
 * @since 2025-05-04 14:02:35
 */
public class NumberOfEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] cnt = new int[100];
        int ans = 0;
        for (int[] d : dominoes) {
            int a = d[0];
            int b = d[1];
            // 相当于 min(a, b) * 10 + max(a, b)
            int code = a < b ? a * 10 + b : b * 10 + a;
            ans += cnt[code];
            cnt[code]++;
        }
        return ans;
    }
}
