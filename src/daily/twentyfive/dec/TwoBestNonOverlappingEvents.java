package daily.twentyfive.dec;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2054. 两个最好的不重叠活动
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-23 04:59:33
 */
public class TwoBestNonOverlappingEvents {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        int[] starts = new int[n];
        for (int i = 0; i < n; i++) starts[i] = events[i][0];
        int[] sufMax = new int[n + 1];
        sufMax[n] = 0;
        for (int i = n - 1; i >= 0; i--)
            sufMax[i] = Math.max(sufMax[i + 1], events[i][2]);
        int ans = 0;
        for (int[] event : events) {
            int end = event[1];
            int val = event[2];
            if (val > ans) ans = val;
            int j = lowerBound(starts, end + 1);
            int bestSecond = sufMax[j];
            ans = Math.max(ans, val + bestSecond);
        }
        return ans;
    }

    private int lowerBound(int[] a, int target) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a[m] >= target) r = m;
            else l = m + 1;
        }
        return l;
    }
}
