package contest.leetcode.daily.twentysix.jan;

/**
 * 3507. 移除最小数对使数组有序 I
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-01-22 14:03:28
 */
public class MinimumPairRemovalToSortArrayI {
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = nums[i];
        int len = n;
        int ops = 0;
        while (true) {
            if (len <= 1) return ops;
            boolean nonDecreasing = true;
            long bestSum = Long.MAX_VALUE;
            int bestIdx = 0;
            for (int i = 0; i < len - 1; i++) {
                if (a[i] > a[i + 1]) nonDecreasing = false;
                long s = a[i] + a[i + 1];
                if (s < bestSum) {
                    bestSum = s;
                    bestIdx = i;
                }
            }
            if (nonDecreasing) return ops;
            a[bestIdx] = a[bestIdx] + a[bestIdx + 1];
            for (int j = bestIdx + 1; j < len - 1; j++) a[j] = a[j + 1];
            len--;
            ops++;
        }
    }
}
