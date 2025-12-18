package backtracking;

import java.util.Arrays;

/**
 * 473. 火柴拼正方形
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-19 03:53:52
 */
public class MatchsticksToSquare {
    public boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length;
        if (n < 4) return false;
        long sum = 0;
        int max = 0;
        for (int x : matchsticks) {
            sum += x;
            if (x > max) max = x;
        }
        if (sum % 4 != 0) return false;
        int side = (int) (sum / 4);
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        int[] sides = new int[4];
        return dfs(matchsticks, 0, sides, side);
    }

    private boolean dfs(int[] a, int idx, int[] sides, int side) {
        if (idx == a.length) return true;
        int len = a[idx];
        int prev = -1;
        for (int i = 0; i < 4; i++) {
            int cur = sides[i];
            if (cur == prev) continue;
            if (cur + len > side) continue;
            sides[i] = cur + len;
            if (dfs(a, idx + 1, sides, side)) return true;
            sides[i] = cur;
            prev = cur;
            if (cur == 0) break;
        }
        return false;
    }

    private void reverse(int[] a) {
        for (int l = 0, r = a.length - 1; l < r; l++, r--) {
            int t = a[l];
            a[l] = a[r];
            a[r] = t;
        }
    }
}
