package daily.twentyfive.april;

/**
 * 2962. 统计最大元素出现至少 K 次的子数组
 *
 * @author AhogeK
 * @since 2025-04-29 17:10:34
 */
public class CountSubarraysWhereMaxElementAppearsAtLeastKTimes {
    public long countSubarrays(int[] nums, int k) {
        int max = 0;
        for (int num : nums)
            if (num > max)
                max = num;

        long result = 0;
        int left = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == max)
                count++;

            while (count >= k) {
                result += nums.length - right;
                if (nums[left] == max)
                    count--;
                left++;
            }
        }

        return result;
    }
}
