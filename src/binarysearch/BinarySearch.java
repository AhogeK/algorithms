package binarysearch;

/**
 * 二分查找
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-03-31 11:09:23
 */
public class BinarySearch {

    /**
     * 二分查找 思路1 循环中找到元素直接返回
     *
     * @param nums   有序数组
     * @param target 目标值
     * @return 目标值在数组中的索引
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
