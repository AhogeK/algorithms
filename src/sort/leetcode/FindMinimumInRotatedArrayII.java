package sort.leetcode;

/**
 * @author AhogeK
 * @since 2025-03-01 23:31:29
 */
public class FindMinimumInRotatedArrayII {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // 最小值在右半部分
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                // 最小值在左半部分（包括mid）
                right = mid;
            } else {
                // nums[mid] == nums[right]，无法确定方向
                // 保守地缩小搜索范围
                right--;
            }
        }

        return nums[left];
    }
}
