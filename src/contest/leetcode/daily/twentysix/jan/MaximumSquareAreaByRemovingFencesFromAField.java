package contest.leetcode.daily.twentysix.jan;

import java.util.Arrays;

/**
 * 2975. 移除栅栏得到的正方形田地的最大面积
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-01-16 20:03:10
 */
public class MaximumSquareAreaByRemovingFencesFromAField {
    private static final int MOD = 1_000_000_007;

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int[] hPos = withBoundsAndSort(hFences, 1, m);
        int[] vPos = withBoundsAndSort(vFences, 1, n);

        long hPairs = pairsCount(hPos.length);
        long vPairs = pairsCount(vPos.length);

        int best;
        if (hPairs <= vPairs) {
            IntHashSet diffs = buildDiffSet(hPos);
            best = maxCommonDiff(vPos, diffs);
        } else {
            IntHashSet diffs = buildDiffSet(vPos);
            best = maxCommonDiff(hPos, diffs);
        }

        if (best == 0)
            return -1;
        long area = (long) best * best % MOD;
        return (int) area;
    }

    private static int[] withBoundsAndSort(int[] fences, int low, int high) {
        int[] pos = new int[fences.length + 2];
        pos[0] = low;
        pos[1] = high;
        System.arraycopy(fences, 0, pos, 2, fences.length);
        Arrays.sort(pos);
        return pos;
    }

    private static long pairsCount(int k) {
        return (long) k * (k - 1) / 2;
    }

    private static IntHashSet buildDiffSet(int[] pos) {
        int k = pos.length;
        int expected = (int) ((long) k * (k - 1) / 2);
        IntHashSet set = new IntHashSet(expected);

        for (int i = 0; i < k; i++) {
            int pi = pos[i];
            for (int j = i + 1; j < k; j++) {
                set.add(pos[j] - pi);
            }
        }
        return set;
    }

    private static int maxCommonDiff(int[] pos, IntHashSet set) {
        int k = pos.length;
        int best = 0;

        for (int i = 0; i < k; i++) {
            int pi = pos[i];
            for (int j = i + 1; j < k; j++) {
                int d = pos[j] - pi;
                if (d > best && set.contains(d))
                    best = d;
            }
        }
        return best;
    }

    /**
     * 仅存正整数 key 的开地址哈希集合：
     * - key == 0 不会出现（差值必为正）
     * - table 中用 (key + 1) 存储，0 表示空槽
     */
    private static final class IntHashSet {
        private int[] table;
        private int mask;
        private int size;
        private int threshold;

        IntHashSet(int expectedSize) {
            int cap = 1;
            int need = (int) Math.ceil(expectedSize / 0.7);
            while (cap < need)
                cap <<= 1;
            table = new int[Math.max(4, cap)];
            mask = table.length - 1;
            threshold = (int) (table.length * 0.7);
        }

        boolean contains(int key) {
            int k = key + 1;
            int idx = mix(key) & mask;
            while (true) {
                int cur = table[idx];
                if (cur == 0)
                    return false;
                if (cur == k)
                    return true;
                idx = (idx + 1) & mask;
            }
        }

        void add(int key) {
            if (size >= threshold)
                rehash();
            int k = key + 1;
            int idx = mix(key) & mask;
            while (true) {
                int cur = table[idx];
                if (cur == 0) {
                    table[idx] = k;
                    size++;
                    return;
                }
                if (cur == k)
                    return;
                idx = (idx + 1) & mask;
            }
        }

        private void rehash() {
            int[] old = table;
            int[] nw = new int[old.length << 1];
            table = nw;
            mask = nw.length - 1;
            threshold = (int) (nw.length * 0.7);
            size = 0;

            for (int stored : old) {
                if (stored != 0) {
                    int key = stored - 1;
                    int idx = mix(key) & mask;
                    while (nw[idx] != 0)
                        idx = (idx + 1) & mask;
                    nw[idx] = stored;
                    size++;
                }
            }
        }

        private static int mix(int x) {
            x ^= (x >>> 16);
            x *= 0x7feb352d;
            x ^= (x >>> 15);
            x *= 0x846ca68b;
            x ^= (x >>> 16);
            return x;
        }
    }
}
