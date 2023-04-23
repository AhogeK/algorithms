package binarysearch;

/**
 * 「力扣」33. 搜索旋转排序数组
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-04-23 11:33:25
 */
public class SearchRotatedSortedArray {

    public int search(int[] nums, int target) {
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
        // 此时 left == right，所以最小值为 nums[left] 或者 nums[right]
        int min = left;
        // 重置 left 和 right
        left = 0;
        right = nums.length - 1;
        // 判断 target 是在最小值的左边还是右边
        if (target >= nums[min] && target <= nums[right]) {
            left = min;
        } else {
            right = min;
        }
        // 标准的二分查找模板
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 如果中间值等于 target，直接返回
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) { // 如果中间值小于 target，说明 target 在右边
                left = mid + 1;
            } else { // 如果中间值大于 target，说明 target 在左边
                right = mid - 1;
            }
        }
        // 如果没有找到，返回 -1
        return -1;
    }
}
