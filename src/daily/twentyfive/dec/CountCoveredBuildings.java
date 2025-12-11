package daily.twentyfive.dec;

import java.util.Arrays;

/**
 * 3531. 统计被覆盖的建筑
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-11 15:50:10
 */
public class CountCoveredBuildings {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int[] maxRow = new int[n + 1];
        int[] minRow = new int[n + 1];
        int[] maxCol = new int[n + 1];
        int[] minCol = new int[n + 1];
        Arrays.fill(minRow, n + 1);
        Arrays.fill(minCol, n + 1);
        for (int[] p : buildings) {
            int x = p[0];
            int y = p[1];
            maxRow[y] = Math.max(maxRow[y], x);
            minRow[y] = Math.min(minRow[y], x);
            maxCol[x] = Math.max(maxCol[x], y);
            minCol[x] = Math.min(minCol[x], y);
        }
        int res = 0;
        for (int[] p : buildings) {
            int x = p[0];
            int y = p[1];
            if (x > minRow[y] && x < maxRow[y] && y > minCol[x] && y < maxCol[x])
                res++;
        }
        return res;
    }
}
