package stackqueue;

import java.util.Arrays;

/**
 * 239. 滑动窗口最大值
 *
 * @author AhogeK
 * @since 2025-05-31 09:13:17
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int[] dq = new int[n];
        int head = 0, tail = 0;
        for (int i = 0; i < n; i++) {
            while (head < tail && nums[i] >= nums[dq[tail - 1]])
                tail--;
            dq[tail++] = i;
            if (dq[head] <= i - k)
                head++;
            if (i >= k - 1)
                ans[i - k + 1] = nums[dq[head]];
        }
        return ans;
    }
}
