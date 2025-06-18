package daily.twentyfive.jun;

import java.util.Arrays;

/**
 * 2966. 划分数组并满足最大差限制
 *
 * @author AhogeK
 * @since 2025-06-18 17:04:11
 */
public class DivideArrayIntoArraysWithMaxDifference {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] ans = new int[nums.length / 3][];
        for (int i = 0; i < nums.length; i += 3) {
            if (nums[i + 2] - nums[i] <= k) {
                ans[i / 3] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
            } else {
                ans = new int[0][];
                return ans;
            }
        }
        return ans;
    }
}
