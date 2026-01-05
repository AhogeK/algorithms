package contest.leetcode.daily.twentysix.jan;

/**
 * 1975. 最大方阵和
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-01-05 18:54:38
 */
public class MaximumMatrixSum {
    public long maxMatrixSum(int[][] matrix) {
        long totalSum = 0;
        int minAbs = Integer.MAX_VALUE;
        int negativeNum = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                int absV = Math.abs(num);
                totalSum += absV;
                if (absV < minAbs) minAbs = absV;
                if (num < 0) negativeNum++;
            }
        }
        if ((negativeNum & 1) == 1) {
            totalSum -= 2L * minAbs;
        }
        return totalSum;
    }
}
