package contest.leetcode.daily.twentysix.jan;

import java.util.Arrays;

/**
 * 3453. 分割正方形 I
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-01-13 16:45:16
 */
public class SeparateSquaresI {
    public double separateSquares(int[][] squares) {
        int n = squares.length;
        double totalArea = 0;

        long[] events = new long[2 * n];

        for (int i = 0; i < n; i++) {
            int y = squares[i][1];
            int l = squares[i][2];

            totalArea += (long) l * l;

            events[2 * i] = ((long) y << 32) | (l & 0xFFFFFFFFL);
            events[2 * i + 1] = ((long) (y + l) << 32) | (-l & 0xFFFFFFFFL);
        }

        Arrays.sort(events);

        double target = totalArea / 2.0;
        double currentArea = 0;
        long currentWidth = 0;

        for (int i = 0; i < events.length; i++) {
            int y = (int) (events[i] >> 32);
            int diff = (int) events[i];

            if (i > 0) {
                int prevY = (int) (events[i - 1] >> 32);

                if (y > prevY) {
                    double segmentArea = (double) (y - prevY) * currentWidth;

                    if (currentArea + segmentArea >= target) {
                        double missingArea = target - currentArea;
                        double neededHeight = missingArea / currentWidth;
                        return prevY + neededHeight;
                    }

                    currentArea += segmentArea;
                }
            }

            currentWidth += diff;
        }

        return 0.0;
    }
}
