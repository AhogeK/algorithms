package stackqueue;

/**
 * 42. 接雨水
 *
 * @author AhogeK
 * @since 2025-05-19 22:16:08
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length, res = 0;
        int[] stack = new int[n];
        int top = -1;
        for (int i = 0; i < n; i++) {
            while (top != -1 && height[i] > height[stack[top]]) {
                int bot = stack[top--];
                if (top == -1) break;
                int left = stack[top];
                int width = i - left - 1;
                int h = Math.min(height[left], height[i]) - height[bot];
                if (h > 0) res += width * h;
            }
            stack[++top] = i;
        }
        return res;
    }
}
