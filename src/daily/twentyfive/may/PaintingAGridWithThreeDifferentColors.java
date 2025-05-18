package daily.twentyfive.may;

import java.util.Arrays;

/**
 * 1931. 用三种不同颜色为网格涂色
 *
 * @author AhogeK
 * @since 2025-05-18 17:32:33
 */
public class PaintingAGridWithThreeDifferentColors {
    static final int MOD = 1_000_000_007;

    public int colorTheGrid(int m, int n) {
        // 每列2位编码，状态压缩总数
        int max = 1 << (2 * m);
        int[] valid = new int[max];
        // 有效状态数
        int cnt = 0;

        // 枚举每一列的所有合规状态
        for (int s = 0; s < max; s++) {
            int pre = -1, x = s;
            boolean ok = true;
            for (int i = 0; i < m; i++) {
                int c = x & 3;
                // 不能出现非法色值&本列上下相邻同色
                if (c == 3 || pre == c) {
                    ok = false;
                    break;
                }
                pre = c;
                x >>= 2;
            }
            if (ok) valid[cnt++] = s; // 保存能作为一列的所有合法状态
        }

        // compat[i][*] 对应valid[i]状态时，哪些状态可以作为它的前列（横向兼容）
        int[][] compat = new int[cnt][cnt];
        int[] len = new int[cnt];
        for (int i = 0; i < cnt; ++i)
            for (int j = 0; j < cnt; ++j)
                if (check(valid[i], valid[j], m))
                    compat[i][len[i]++] = j; // 只保存编号，不存真状态

        // DP初始化
        int[] dp = new int[cnt], tmp = new int[cnt];
        Arrays.fill(dp, 1); // 第一列每种状态都有1种方案

        for (int col = 1; col < n; ++col) {
            Arrays.fill(tmp, 0);
            for (int i = 0; i < cnt; ++i)
                for (int x = 0; x < len[i]; ++x)
                    tmp[i] = (tmp[i] + dp[compat[i][x]]) % MOD;
            int[] t = dp;
            dp = tmp;
            tmp = t; // 空间复用
        }
        int res = 0;
        for (int x : dp) res = (res + x) % MOD;
        return res;
    }

    private boolean check(int s1, int s2, int m) {
        for (int i = 0; i < m; ++i) {
            if ((s1 & 3) == (s2 & 3)) return false;
            s1 >>= 2;
            s2 >>= 2;
        }
        return true;
    }
}
