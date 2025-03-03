package sort.leetcode;

/**
 * @author AhogeK
 * @since 2025-03-01 19:24:01
 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // 与有边界元素比较
            if (nums[mid] > nums[right]) {
                // 最小值在又半部分
                left = mid + 1;
            } else {
                // 最小值在左半部分（包括mid）
                right = mid;
            }
        }

        // 当left==right时，即找到最小值
        return nums[left];
    }
}
