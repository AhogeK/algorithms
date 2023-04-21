package binarysearch;

/**
 * 二分查找：二分下标
 * 35. 搜索插入位置
 * <a href="https://leetcode.cn/problems/search-insert-position/">题目网址</a>
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-04-21 15:32:11
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
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
        return left;
    }
}
