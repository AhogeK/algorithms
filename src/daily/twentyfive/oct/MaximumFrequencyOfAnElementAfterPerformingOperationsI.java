package daily.twentyfive.oct;

/**
 * 3346. 执行操作后元素的最高频率 I
 *
 * @author AhogeK
 * @since 2025-10-21 14:55:29
 */
public class MaximumFrequencyOfAnElementAfterPerformingOperationsI {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int mn = Integer.MAX_VALUE;
        int mx = Integer.MIN_VALUE;
        for (int n : nums) {
            mn = Math.min(mn, n);
            mx = Math.max(mx, n);
        }
        int move = mn - k < 0 ? Math.abs(mn - k) : 0;
        int len = mx + move + k + 2;
        int[] diff = new int[len];
        int[] cnt = new int[len];
        for (int n : nums) {
            n += move;
            diff[n - k]++;
            diff[n + k + 1]--;
            cnt[n]++;
        }
        int s = 0;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            s += diff[i];
            int c = cnt[i];
            int op = Math.min(numOperations, s - c);
            ans = Math.max(ans, c + op);
        }
        return ans;
    }
}
