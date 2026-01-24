package contest.leetcode.daily.twentysix.jan.twentythird;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 3510. 移除最小数对使数组有序 II
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-01-23 14:49:15
 */
class Solution {
    public int minimumPairRemoval(int[] nums) {
        final int n = nums.length;
        if (n <= 1) return 0;

        long[] val = new long[n];
        for (int i = 0; i < n; i++) val[i] = nums[i];

        int[] prev = new int[n];
        int[] next = new int[n];
        boolean[] alive = new boolean[n];

        Arrays.setAll(prev, i -> i - 1);
        Arrays.setAll(next, i -> (i + 1 < n) ? (i + 1) : -1);
        Arrays.fill(alive, true);

        int bad = 0;
        for (int i = 0; i + 1 < n; i++) {
            if (val[i] > val[i + 1]) bad++;
        }
        if (bad == 0) return 0;

        PriorityQueue<Entry> pq = new PriorityQueue<>((a, b) -> {
            int c = Long.compare(a.sum, b.sum);
            return (c != 0) ? c : Integer.compare(a.left, b.left);
        });

        for (int i = 0; i + 1 < n; i++) {
            pq.add(new Entry(val[i] + val[i + 1], i, i + 1));
        }

        int ops = 0;

        while (bad > 0) {
            Entry e = pq.poll();
            int i = e.left;
            int j = e.right;

            if (i < 0 || j < 0 || i >= n || j >= n) continue;
            if (!alive[i] || !alive[j]) continue;
            if (next[i] != j) continue;

            long actualSum = val[i] + val[j];
            if (actualSum != e.sum) continue;

            int p = prev[i];
            int r = next[j];

            if (p != -1) bad -= (val[p] > val[i]) ? 1 : 0;
            bad -= (val[i] > val[j]) ? 1 : 0;
            if (r != -1) bad -= (val[j] > val[r]) ? 1 : 0;

            val[i] = actualSum;
            alive[j] = false;

            next[i] = r;
            if (r != -1) prev[r] = i;

            if (p != -1) bad += (val[p] > val[i]) ? 1 : 0;
            if (r != -1) bad += (val[i] > val[r]) ? 1 : 0;

            if (p != -1) pq.add(new Entry(val[p] + val[i], p, i));
            if (r != -1) pq.add(new Entry(val[i] + val[r], i, r));

            ops++;
        }

        return ops;
    }

    private record Entry(long sum, int left, int right) {
    }
}
