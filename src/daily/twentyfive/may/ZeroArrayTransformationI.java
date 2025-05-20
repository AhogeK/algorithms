package daily.twentyfive.may;

/**
 * 3355. 零数组变换 I
 *
 * @author AhogeK
 * @since 2025-05-20 20:53:26
 */
public class ZeroArrayTransformationI {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        for (int[] q : queries) {
            diff[q[0]]++;
            diff[q[1] + 1]--;
        }
        int cover = 0;
        for (int i = 0; i < n; i++) {
            cover += diff[i];
            if (nums[i] > cover) return false;
        }
        return true;
    }
}
