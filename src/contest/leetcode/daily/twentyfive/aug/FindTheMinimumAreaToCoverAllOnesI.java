package contest.leetcode.daily.twentyfive.aug;

/**
 * 3195. 包含所有 1 的最小矩形面积 I
 *
 * @author AhogeK
 * @since 2025-08-22 16:24:27
 */
public class FindTheMinimumAreaToCoverAllOnesI {
    public int minimumArea(int[][] grid) {
        int minR = 1000;
        int maxR = -1;
        int minC = 1000;
        int maxC = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    minR = Math.min(minR, i);
                    maxR = Math.max(maxR, i);
                    minC = Math.min(minC, j);
                    maxC = Math.max(maxC, j);
                }
            }
        }
        return (maxR - minR + 1) * (maxC - minC + 1);
    }
}
