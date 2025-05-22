package stackqueue;

/**
 * 503. 下一个更大元素 II
 *
 * @author AhogeK
 * @since 2025-05-23 01:23:58
 */
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] stack = new int[n];
        int top = -1;
        for (int i = 0; i < n; i++)
            ans[i] = -1;
        for (int i = 0; i < n * 2; i++) {
            int j = i % n;
            while (top >= 0 && nums[j] > nums[stack[top]]) {
                int idx = stack[top--];
                ans[idx] = nums[j];
            }
            if (i < n) stack[++top] = j;
        }
        return ans;
    }
}
