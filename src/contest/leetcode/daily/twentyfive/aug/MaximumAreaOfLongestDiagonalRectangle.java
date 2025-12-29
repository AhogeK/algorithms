package contest.leetcode.daily.twentyfive.aug;

/**
 * 3000. 对角线最长的矩形的面积
 *
 * @author AhogeK
 * @since 2025-08-26 22:01:23
 */
public class MaximumAreaOfLongestDiagonalRectangle {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiag = 0;
        int maxArea = 0;
        for (int[] d : dimensions) {
            int diag = d[0] * d[0] + d[1] * d[1];
            int area = d[0] * d[1];
            if (diag > maxDiag || (diag == maxDiag && area > maxArea)) {
                maxDiag = diag;
                maxArea = area;
            }
        }
        return maxArea;
    }
}
