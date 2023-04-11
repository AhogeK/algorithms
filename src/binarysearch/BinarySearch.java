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

    /**
     * 使用「递归」写法完成二分查找
     *
     * @param nums   有序数组
     * @param target 目标值
     * @return 目标值在数组中的索引
     */
    public int search2(int[] nums, int target) {
        return binarySearchRecursive(nums, target, 0, nums.length - 1);
    }

    /**
     * 二分查找 递归
     *
     * @param nums   用于查找的有序数组
     * @param target 目标值
     * @param left   左下标
     * @param right  右下标
     * @return 目标值在数组中的索引
     */
    private int binarySearchRecursive(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binarySearchRecursive(nums, target, mid + 1, right);
        } else {
            return binarySearchRecursive(nums, target, left, mid - 1);
        }
    }
}
