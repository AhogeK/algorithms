package binarysearch;

/**
 * 「力扣」81. 搜索旋转排序数组 II
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-04-23 11:48:05
 */
public class SearchRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) { // 检查是否找到 target
                return true;
            }

            if (nums[mid] > nums[right]) {
                if (target >= nums[left] && target < nums[mid]) { // 检查 target 是否在有序的左半部分
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[right]) {
                if (target > nums[mid] && target <= nums[right]) { // 检查 target 是否在有序的右半部分
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else { // 如果中间值等于最右边的值，无法确定最小值所在的位置，右边界减一
                if (nums[right] == target) { // 检查是否找到 target
                    return true;
                }
                right--;
            }
        }

        return nums[left] == target;
    }
}

