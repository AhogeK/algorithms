package binarysearch;

/**
 * 「力扣」153. 寻找旋转排序数组中的最小值
 * <a href="https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/">题目网址</a>
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-04-23 11:08:39
 */
public class FindMin {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 如果中间值大于最右边的值，说明最小值在右边
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
