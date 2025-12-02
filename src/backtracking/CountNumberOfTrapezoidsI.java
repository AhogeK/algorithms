package backtracking;

import java.util.Arrays;

/**
 * 3623. 统计梯形的数目 I
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-02 16:07:59
 */
public class CountNumberOfTrapezoidsI {
    public int countTrapezoids(int[][] points) {
        int n = points.length;
        int[] ys = new int[n];
        for (int i = 0; i < n; i++) {
            ys[i] = points[i][1];
        }
        Arrays.sort(ys);
        long ans = 0;
        long sumComb = 0;
        final long MOD = 1_000_000_007;
        int currentCount = 0;
        for (int i = 0; i < n; i++) {
            currentCount++;
            if (i == n - 1 || ys[i] != ys[i + 1]) {
                if (currentCount >= 2) {
                    long lines = (long) currentCount * (currentCount - 1) / 2;
                    lines %= MOD;
                    ans = (ans + lines * sumComb) % MOD;
                    sumComb = (sumComb + lines) % MOD;
                }
                currentCount = 0;
            }
        }
        return (int) ans;
    }
}
