package binarysearch;

/**
 * 二分查找：二分下标
 * 35. 在排序数组中查找元素的第一个和最后一个位置
 * <a href="https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/">题目网址</a>
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-04-21 15:42:53
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int leftIndex = binarySearch(nums, target, true);
        if (leftIndex == nums.length || nums[leftIndex] != target) {
            return result;
        }
        result[0] = leftIndex;
        result[1] = binarySearch(nums, target, false) - 1;
        return result;
    }

    /**
     * 二分查找
     *
     * @param nums    有序数组
     * @param target  目标值
     * @param isFirst 是否查找第一个位置
     * @return 目标值在数组中的索引
     */
    private int binarySearch(int[] nums, int target, boolean isFirst) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > target || (isFirst && nums[mid] == target)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
