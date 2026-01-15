package contest.leetcode.daily.twentysix.jan;

/**
 * 2943. 最大化网格图中正方形空洞的面积
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-01-15 19:18:05
 */
public class MaximizeAreaOfSquareHoleInGrid {
    private static int maxMergedLen(int[] a) {
        insertionSort(a);

        int bestRun = 1;
        int run = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[i - 1] + 1) {
                run++;
            } else {
                if (run > bestRun) bestRun = run;
                run = 1;
            }
        }
        if (run > bestRun) bestRun = run;

        return bestRun + 1;
    }

    private static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int x = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > x) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = x;
        }
    }

    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int h = maxMergedLen(hBars);
        int v = maxMergedLen(vBars);
        int side = Math.min(h, v);
        return side * side;
    }
}
