package daily.twentyfive.nov;

/**
 * 3234. 统计 1 显著的字符串的数量
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-11-15 21:08:47
 */
public class CountTheNumberOfSubstringsWithDominantOnes {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] pos0 = new int[n + 1];
        pos0[0] = -1;
        int size = 1;
        int total1 = 0;
        int ans = 0;

        for (int r = 0; r < n; r++) {
            if (s.charAt(r) == '0') {
                pos0[size++] = r;
            } else {
                total1++;
                ans += r - pos0[size - 1];
            }

            for (int i = size - 1; i > 0 && (size - i) * (size - i) <= total1; i--) {
                int p = pos0[i - 1];
                int q = pos0[i];
                int cnt0 = size - i;
                int cnt1 = r - q + 1 - cnt0;
                ans += Math.max(q - Math.max(cnt0 * cnt0 - cnt1, 0) - p, 0);
            }
        }

        return ans;
    }
}
