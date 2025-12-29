package contest.leetcode.daily.twentyfive.sep;

/**
 * 812. 最大三角形面积
 *
 * @author AhogeK
 * @since 2025-09-27 16:06:02
 */
public class LargestTriangleArea {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double maxArea = 0.0;
        for (int i = 0; i < n; i++) {
            int[] p1 = points[i];
            for (int j = i + 1; j < n - 1; j++) {
                int[] p2 = points[j];
                for (int k = j + 1; k < n; k++) {
                    int[] p3 = points[k];
                    double area = area(p1, p2, p3);
                    if (area > maxArea) maxArea = area;
                }
            }
        }
        return maxArea;
    }

    private double area(int[] p1, int[] p2, int[] p3) {
        return Math.abs(
                p1[0] * (p2[1] - p3[1]) +
                p2[0] * (p3[1] - p1[1]) +
                p3[0] * (p1[1] - p2[1])
        );
    }
}
