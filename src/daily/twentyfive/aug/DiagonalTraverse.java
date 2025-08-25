package daily.twentyfive.aug;

/**
 * 498. 对角线遍历
 *
 * @author AhogeK
 * @since 2025-08-25 15:45:27
 */
public class DiagonalTraverse {
    public int[] findDiagonalOrOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        int index = 0;
        for (int k = 0; k < m + n - 1; k++) {
            int startRow = Math.max(0, k - n + 1);
            int endRow = Math.min(k, m - 1);
            if (k % 2 == 0)
                for (int i = endRow; i >= startRow; i--)
                    result[index++] = mat[i][k - i];
            else
                for (int i = startRow; i <= endRow; i++)
                    result[index++] = mat[i][k - i];
        }
        return result;
    }
}
