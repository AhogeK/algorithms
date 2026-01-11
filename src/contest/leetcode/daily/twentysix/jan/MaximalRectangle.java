package contest.leetcode.daily.twentysix.jan;

/**
 * 85. 最大矩形
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-01-11 22:21:29
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        int[] stack = new int[cols + 1];
        int top;

        for (char[] chars : matrix) {
            for (int col = 0; col < cols; col++) {
                if (chars[col] == '1') {
                    heights[col] += 1;
                } else {
                    heights[col] = 0;
                }
            }

            top = -1;

            for (int i = 0; i <= cols; i++) {
                int currentHeight = (i == cols) ? -1 : heights[i];

                while (top != -1 && currentHeight < heights[stack[top]]) {
                    int h = heights[stack[top]];
                    top--;

                    int w = (top == -1) ? i : (i - stack[top] - 1);

                    maxArea = Math.max(maxArea, h * w);
                }

                top++;
                stack[top] = i;
            }
        }

        return maxArea;
    }
}
