package daily.twentyfive.oct;

/**
 * 2598. 执行操作后的最大 MEX
 *
 * @author AhogeK
 * @since 2025-10-16 13:46:09
 */
public class SmallestMissingNonNegativeIntegerAfterOperations {
    public int findSmallestInteger(int[] nums, int value) {
        int[] cnt = new int[value];
        for (int x : nums) {
            cnt[((x % value) + value) % value]++;
        }
        int mex = 0;
        while (true) {
            int r = mex % value;
            if (cnt[r] == 0) {
                return mex;
            }
            cnt[r]--;
            mex++;
        }
    }
}
