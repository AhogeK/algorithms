package contest.leetcode.daily.twentysix.jan;

/**
 * 3047. 求交集区域内的最大正方形面积
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-01-17 13:49:19
 */
public class FindTheLargestAreaOfSquareInsideTwoRectangles {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;

        int bestSide = 0;
        for (int i = 0; i < n; i++) {
            int ax1 = bottomLeft[i][0], ay1 = bottomLeft[i][1];
            int ax2 = topRight[i][0], ay2 = topRight[i][1];

            int minSideI = Math.min(ax2 - ax1, ay2 - ay1);
            if (minSideI <= bestSide)
                continue;

            for (int j = i + 1; j < n; j++) {
                int bx1 = bottomLeft[j][0], by1 = bottomLeft[j][1];
                int bx2 = topRight[j][0], by2 = topRight[j][1];

                int left = Math.max(ax1, bx1);
                int right = Math.min(ax2, bx2);
                int bottom = Math.max(ay1, by1);
                int top = Math.min(ay2, by2);

                int w = right - left;
                int h = top - bottom;
                if (w <= 0 || h <= 0)
                    continue;

                int side = Math.min(w, h);
                if (side > bestSide)
                    bestSide = side;
            }
        }
        return (long) bestSide * bestSide;
    }
}
