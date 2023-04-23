package binarysearch;

/**
 * 「力扣」154. 寻找旋转排序数组中的最小值 II
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-04-23 11:22:07
 */
public class FindMinII {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        // 二分查找的终止条件是 left == right
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 如果中间值大于最右边的值，说明最小值在右边
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) { // 如果中间值小于最右边的值，说明最小值在左边
                right = mid;
            } else { // 如果中间值等于最右边的值，说明最小值在左边或者右边，此时无法确定，只能将右边界减一
                right--;
            }
        }
        return nums[left];
    }
}
