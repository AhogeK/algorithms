package daily.twentyfive.april;

import java.util.Arrays;

/**
 * 2364. 统计坏数对的数目
 *
 * @author AhogeK
 * @since 2025-04-18 08:04:44
 */
public class CountNumberOfBadPairs {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++)
            // 转换 nums[i] = nums[i] - i
            nums[i] -= i;
        Arrays.sort(nums);
        long res = 0;
        int prev = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[prev])
                prev = i;
            res += prev;
        }
        return res;
    }
}
