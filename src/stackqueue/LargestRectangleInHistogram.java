package stackqueue;

/**
 * 84. 柱状图中最大的矩形
 *
 * @author AhogeK
 * @since 2025-05-23 01:50:55
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] hs = new int[n + 1];
        System.arraycopy(heights, 0, hs, 0, n);
        hs[n] = 0;
        int[] stack = new int[n + 2];
        int top = -1;
        int maxArea = 0;
        for (int i = 0; i <= n; i++) {
            while (top >= 0 && hs[i] < hs[stack[top]]) {
                int height = hs[stack[top--]];
                int left = top == -1 ? -1 : stack[top];
                int width = i - left - 1;
                int area = height * width;
                if (area > maxArea) maxArea = area;
            }
            stack[++top] = i;
        }
        return maxArea;
    }
}
