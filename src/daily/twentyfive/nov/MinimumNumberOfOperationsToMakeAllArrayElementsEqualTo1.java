package daily.twentyfive.nov;

/**
 * 2654. 使数组所有元素变成 1 的最少操作次数
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-11-12 14:53:36
 */
public class MinimumNumberOfOperationsToMakeAllArrayElementsEqualTo1 {

    public int minOperations(int[] nums) {
        int n = nums.length;
        int cnt1 = 0;
        for (int x : nums) if (x == 1) cnt1++;
        if (cnt1 > 0) return n - cnt1;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int g = 0;
            for (int j = i; j < n; j++) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }
        if (minLen == Integer.MAX_VALUE) return -1;
        return minLen + n - 1;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
