package daily.twentyfive.jun;

import java.util.Arrays;

/**
 * 2294. 划分数组使最大差为 K
 *
 * @author AhogeK
 * @since 2025-06-19 20:29:20
 */
public class PartitionArraySuchThatMaximumDifferenceIsK {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 1;
        int rec = nums[0];
        for (int x : nums) {
            if (x - rec > k) {
                ans++;
                rec = x;
            }
        }
        return ans;
    }
}
