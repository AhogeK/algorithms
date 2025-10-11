package daily.twentyfive.oct;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 3186. 施咒的最大总伤害
 *
 * @author AhogeK
 * @since 2025-10-11 12:45:11
 */
public class MaximumTotalDamageWithSpellCasting {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int p : power) cnt.merge(p, 1, Integer::sum);
        int n = cnt.size();
        int[] a = new int[n];
        int i = 0;
        for (int key : cnt.keySet()) a[i++] = key;
        Arrays.sort(a);
        long[] dp = new long[n + 1];
        int j = 0;
        for (i = 0; i < n; i++) {
            while (j < i && a[j] < a[i] - 2) j++;
            dp[i + 1] = Math.max(dp[i], dp[j] + (long) a[i] * cnt.get(a[i]));
        }
        return dp[n];
    }
}
