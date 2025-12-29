package contest.leetcode.daily.twentyfive.may;

/**
 * 75. 颜色分类
 *
 * @author AhogeK
 * @since 2025-05-17 15:31:15
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, i = 0, p2 = n - 1;
        while (i <= p2) {
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = tmp;
                p0++;
                i++;
            } else if (nums[i] == 2) {
                int tmp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = tmp;
                p2--;
            } else {
                i++;
            }
        }
    }
}
