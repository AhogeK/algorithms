package contest.leetcode.daily.twentysix.jan;

import java.util.Arrays;

/**
 * 2976. 转换字符串的最小成本 I
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-01-29 19:24:23
 */
public class MinimumCostToConvertStringI {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        final long INF = Long.MAX_VALUE / 4;
        long[][] dist = new long[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for (int i = 0; i < cost.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            long w = cost[i];
            if (w < dist[u][v]) dist[u][v] = w;
        }
        for (int k = 0; k < 26; k++) {
            long[] dk = dist[k];
            for (int i = 0; i < 26; i++) {
                long dik = dist[i][k];
                if (dik >= INF) continue;
                long[] di = dist[i];
                for (int j = 0; j < 26; j++) {
                    long dkj = dk[j];
                    if (dkj >= INF) continue;
                    long nd = dik + dkj;
                    if (nd < di[j]) di[j] = nd;
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < source.length(); i++) {
            int s = source.charAt(i) - 'a';
            int t = target.charAt(i) - 'a';
            if (s == t) continue;
            long d = dist[s][t];
            if (d >= INF) return -1;
            ans += d;
        }
        return ans;
    }
}
