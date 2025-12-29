package contest.leetcode.daily.twentyfive.july;

/**
 * 2210. 统计数组中峰和谷的数量
 *
 * @author AhogeK
 * @since 2025-07-27 09:40:49
 */
public class CountHillsAndValleysInAnArray {
    public int countHillValley(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int m = 1;
        arr[0] = nums[0];
        for (int i = 1; i < n; i++)
            if (nums[i] != nums[i - 1])
                arr[m++] = nums[i];
        int ans = 0;
        for (int i = 1; i < m - 1; i++)
            if ((arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) || arr[i] < arr[i - 1] && arr[i] < arr[i + 1])
                ans++;
        return ans;
    }
}
