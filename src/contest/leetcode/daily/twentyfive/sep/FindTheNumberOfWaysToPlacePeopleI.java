package contest.leetcode.daily.twentyfive.sep;

import java.util.Arrays;

/**
 * 3025. 人员站位的方案数 I
 *
 * @author AhogeK
 * @since 2025-09-02 02:56:40
 */
public class FindTheNumberOfWaysToPlacePeopleI {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        int count = 0;
        for (int i = 0; i < n; i++) {
            int y1 = points[i][1];
            int maxY = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                int y2 = points[j][1];
                if (y2 <= y1 && y2 > maxY) {
                    count++;
                    maxY = y2;
                }
            }
        }
        return count;
    }
}
