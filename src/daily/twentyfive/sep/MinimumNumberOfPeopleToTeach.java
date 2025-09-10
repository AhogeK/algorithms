package daily.twentyfive.sep;

import java.util.ArrayList;
import java.util.List;

/**
 * 1733. 需要教语言的最少人数
 *
 * @author AhogeK
 * @since 2025-09-10 10:12:16
 */
public class MinimumNumberOfPeopleToTeach {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        boolean[][] know = new boolean[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int l : languages[i - 1]) {
                know[i][l] = true;
            }
        }
        boolean[] needTeachUser = new boolean[m + 1];
        for (int[] f : friendships) {
            int u = f[0];
            int v = f[1];
            boolean ok = false;
            for (int l = 1; l <= n; l++) {
                if (know[u][l] && know[v][l]) {
                    ok = true;
                    break;
                }
            }
            if (!ok) {
                needTeachUser[u] = true;
                needTeachUser[v] = true;
            }
        }
        List<Integer> s = new ArrayList<>();
        for (int i = 1; i <= m; i++)
            if (needTeachUser[i]) s.add(i);
        if (s.isEmpty()) return 0;
        int[] cnt = new int[n + 1];
        for (int u : s)
            for (int l : languages[u - 1]) cnt[l]++;
        int maxCnt = 0;
        for (int l = 1; l <= n; l++)
            maxCnt = Math.max(maxCnt, cnt[l]);
        return s.size() - maxCnt;
    }
}
