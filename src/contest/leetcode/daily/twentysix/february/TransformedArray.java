package contest.leetcode.daily.twentysix.february;

/**
 * 3379. 转换数组
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-02-05 19:47:54
 */
public class TransformedArray {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            if (x == 0) {
                res[i] = 0;
                continue;
            }
            int step = x % n;
            int j = (i + step) % n;
            if (j < 0) j += n;
            res[i] = nums[j];
        }
        return res;
    }
}
