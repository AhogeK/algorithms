package daily.twentyfive.may;

import java.util.Arrays;

/**
 * 3343. 统计平衡排列的数目
 *
 * @author AhogeK
 * @since 2025-05-09 16:06:41
 */
public class CountNumberOfBalancedPermutations {
    private static final int MOD = 1_000_000_007;
    private static final int MX = 41;
    private static final long[] F = new long[MX];
    private static final long[] INV_F = new long[MX];

    static {
        F[0] = 1;
        for (int i = 1; i < MX; i++)
            F[i] = F[i - 1] * i % MOD;

        INV_F[MX - 1] = pow(F[MX - 1], MOD - 2);
        for (int i = MX - 2; i >= 0; i--)
            INV_F[i] = INV_F[i + 1] * (i + 1) % MOD;
    }

    private static long pow(long x, int n) {
        long res = 1;
        while (n > 0) {
            if ((n & 1) == 1)
                res = res * x % MOD;
            x = x * x % MOD;
            n >>= 1;
        }
        return res;
    }


    public int countBalancedPermutations(String num) {
        int[] cnt = new int[10];
        int total = 0;

        for (char c : num.toCharArray()) {
            int d = c - '0';
            cnt[d]++;
            total += d;
        }

        if ((total & 1) != 0)
            return 0;

        int target = total / 2;
        int n = num.length();
        int evenSlots = (n + 1) / 2;

        for (int i = 1; i < 10; i++)
            cnt[i] += cnt[i - 1];

        int[][][] memo = new int[10][evenSlots + 1][target + 1];
        for (int[][] mat : memo)
            for (int[] row : mat)
                Arrays.fill(row, -1);

        int res = dfs(9, evenSlots, target, cnt, memo);

        return (int) (F[evenSlots] * F[n - evenSlots] % MOD * res % MOD);
    }

    private int dfs(int digit, int leftEven, int leftSum, int[] cnt, int[][][] memo) {
        if (digit < 0)
            return (leftEven == 0 && leftSum == 0) ? 1 : 0;
        if (leftSum < 0)
            return 0;
        if (memo[digit][leftEven][leftSum] != -1)
            return memo[digit][leftEven][leftSum];

        int currentCnt = cnt[digit] - (digit > 0 ? cnt[digit - 1] : 0);
        int maxK = 0;
        int minK = 0;

        if (digit == 0) {
            if (leftSum != 0)
                return 0;
            maxK = Math.min(currentCnt, leftEven);
            minK = Math.max(0, currentCnt - (cnt[9] - leftEven));
        } else {
            maxK = Math.min(currentCnt, Math.min(leftEven, leftSum / digit));
            minK = Math.max(0, currentCnt - (cnt[digit] - leftEven));
        }

        long res = 0;
        for (int k = minK; k <= maxK; k++) {
            long comb = INV_F[k] * INV_F[currentCnt - k] % MOD;
            res = (res + comb * dfs(digit - 1, leftEven - k, leftSum - k * digit, cnt, memo)) % MOD;
        }

        return memo[digit][leftEven][leftSum] = (int) res;
    }
}
