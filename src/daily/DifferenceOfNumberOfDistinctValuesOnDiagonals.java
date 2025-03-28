package daily;

/**
 * <a href="https://leetcode.cn/problems/difference-of-number-of-distinct-values-on-diagonals">2711. 对角线上不同值的数量差</a>
 *
 * @author AhogeK
 * @since 2025-03-25 20:30:33
 */
public class DifferenceOfNumberOfDistinctValuesOnDiagonals {

    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];

        // 遍历每条副对角线，在矩阵中副对角线满足 i + j - n = k;
        for (int k = 1; k < m + n; k++) {
            // 计算当前对角线的列范围
            int minJ = Math.max(0, n - k); // 确保列索引 >= 0
            int maxJ = Math.min(m + n - 1 - k, n - 1); // 确保行列索引不越界
            long set = 0; // 用位运算表示集合

            for (int j = minJ; j <= maxJ; j++) {
                int i = k + j - n; // // 根据 k 和 j 计算行索引
                ans[i][j] = Long.bitCount(set); // 计算左上对角线不同值的数量
                set |= 1L << grid[i][j];
            }

            set = 0; // 重制集合
            for (int j = maxJ; j >= minJ; j--) {
                int i = k + j - n;
                ans[i][j] = Math.abs(ans[i][j] - Long.bitCount(set)); // 计算最终答案
                set |= 1L << grid[i][j]; // 将当前值加入集合
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {3, 1, 5}, {3, 2, 1}};
        DifferenceOfNumberOfDistinctValuesOnDiagonals solution = new DifferenceOfNumberOfDistinctValuesOnDiagonals();
        solution.differenceOfDistinctValues(grid);
    }
}
