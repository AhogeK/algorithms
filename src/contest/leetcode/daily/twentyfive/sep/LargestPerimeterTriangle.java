package contest.leetcode.daily.twentyfive.sep;

import java.util.Arrays;

/**
 * 976. 三角形的最大周长
 *
 * @author AhogeK
 * @since 2025-09-28 19:05:24
 */
public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            int a = nums[i - 2], b = nums[i - 1], c = nums[i];
            if (a + b > c) return a + b + c;
        }
        return 0;
    }
}
