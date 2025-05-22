package stackqueue;

/**
 * 496. 下一个更大元素 I
 *
 * @author AhogeK
 * @since 2025-05-23 00:56:37
 */
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] next = new int[1001];
        for (int i = 0; i < nums2.length; i++)
            next[i] = -1;
        int[] stack = new int[nums2.length];
        int top = -1;
        for (int i = 0; i < nums2.length; i++) {
            while (top >= 0 && nums2[i] > nums2[stack[top]]) {
                int idx = stack[top--];
                next[nums2[idx]] = nums2[i];
            }
            stack[++top] = i;
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++)
            ans[i] = next[nums1[i]];
        return ans;
    }
}
