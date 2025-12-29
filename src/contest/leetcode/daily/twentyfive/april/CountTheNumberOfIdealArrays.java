package contest.leetcode.daily.twentyfive.april;

import java.util.ArrayList;
import java.util.List;

/**
 * 2338. 统计理想数组的数目
 *
 * @author AhogeK
 * @since 2025-04-22 09:26:08
 */
public class CountTheNumberOfIdealArrays {
    static int MOD = 1_000_000_007;
    static int MAX_N = 10_010;
    // 质因子最大只到log2 10^4≈14
    static int MAX_P = 15;

    // 组合数
    static int[][] c = new int[MAX_N + MAX_P][MAX_P + 1];
    // 最小质因子
    static int[] sieve = new int[MAX_N];
    // 存每个数分解后所有质因子幂
    static List<Integer>[] ps = new List[MAX_N];

    public CountTheNumberOfIdealArrays() {
        //  保证只赋值一次
        if (c[0][0] == 1) return;
        for (int i = 0; i < MAX_N; i++) ps[i] = new ArrayList<>();
        // 埃筛预处理最小质因子
        for (int i = 2; i < MAX_N; i++)
            if (sieve[i] == 0)
                for (int j = i; j < MAX_N; j += i)
                    if (sieve[j] == 0)
                        sieve[j] = i;
        // 分解每个x的所有质因子幂次数
        for (int i = 2; i < MAX_N; i++) {
            int x = i;
            while (x > 1) {
                int p = sieve[x];
                int cnt = 0;
                while (x % p == 0) {
                    x /= p;
                    cnt++;
                }
                ps[i].add(cnt);
            }
        }
        // 组合数c[a][b]
        c[0][0] = 1;
        for (int i = 1; i < MAX_N + MAX_P; i++) {
            c[i][0] = 1;
            for (int j = 1; j <= Math.min(i, MAX_P); j++)
                c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % MOD;
        }
    }

    public int idealArrays(int n, int maxValue) {
        long ans = 0;
        for (int x = 1; x <= maxValue; x++) {
            long mul = 1;
            for (int p : ps[x])
                mul = mul * c[n + p - 1][p] % MOD;
            ans = (ans + mul) % MOD;
        }
        return (int) ans;
    }
}
