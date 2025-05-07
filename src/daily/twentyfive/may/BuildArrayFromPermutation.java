package daily.twentyfive.may;

/**
 * 1920. 基于排列构建数组
 *
 * @author AhogeK
 * @since 2025-05-06 14:03:44
 */
public class BuildArrayFromPermutation {

    public int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++)
            ans[i] = nums[nums[i]];
        return ans;
    }
}
