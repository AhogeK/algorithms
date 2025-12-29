package contest.leetcode.daily.twentyfive.may;

/**
 * 3356. 零数组变换 II
 *
 * @author AhogeK
 * @since 2025-05-21 23:42:00
 */
public class ZeroArrayTransformationII {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length, q = queries.length;
        int[] diff = new int[n + 2];
        int k = 0;
        long[] prefixSum = new long[n];

        for (int i = 0; i < n; i++) {
            if (i > 0)
                prefixSum[i] = prefixSum[i - 1] + diff[i];
            long need = nums[i] - prefixSum[i];
            if (need <= 0)
                continue;

            while (k < q && need > 0) {
                int l = queries[k][0], r = queries[k][1], v = queries[k][2];
                diff[l] += v;
                diff[r + 1] -= v;

                if (l <= i && r >= i) {
                    prefixSum[i] += v;
                    need -= v;
                }
                k++;
            }
            if (need > 0)
                return -1;
        }
        return k;
    }
}
