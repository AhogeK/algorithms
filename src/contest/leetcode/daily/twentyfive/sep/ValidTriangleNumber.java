package contest.leetcode.daily.twentyfive.sep;

import java.util.Arrays;

/**
 * 611. 有效三角形的个数
 *
 * @author AhogeK
 * @since 2025-09-26 19:27:28
 */
public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        Arrays.sort(nums);
        int count = 0;
        for (int k = n - 1; k >= 2; k--) {
            int i = 0, j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    count += (j - i);
                    j--;
                } else {
                    i++;
                }
            }
        }
        return count;
    }
}
