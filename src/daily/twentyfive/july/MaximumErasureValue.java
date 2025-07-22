package daily.twentyfive.july;

/**
 * 1695. 删除子数组的最大得分
 *
 * @author AhogeK
 * @since 2025-07-22 09:06:18
 */
public class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        int[] s = new int[10001];
        int ans = 0;
        int x = 0;
        int y = 0;
        for (int num : nums) {
            if (s[num] > y) {
                y = s[num];
            }
            x += num;
            s[num] = x;
            ans = Math.max(ans, x - y);
        }
        return ans;
    }
}
