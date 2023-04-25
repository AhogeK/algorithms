package binarysearch;

/**
 * 「力扣」852. 山脉数组的峰顶索引
 * <a href="https://leetcode.cn/problems/peak-index-in-a-mountain-array/">题目网址</a>
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-04-25 10:38:52
 */
public class PeakIndexInMountainArray {

    public int peakIndexInMountainArray(int[] arr) {
        int left = 1;
        // 因为题目保证了一定存在山峰，所以 right 可以取 arr.length - 2
        int right = arr.length - 2;
        // 二分查找的终止条件是 left == right
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 如果中间值大于中间值右边的值，说明山峰在左边
            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // 此时 left == right，所以最小值为 nums[left] 或者 nums[right]
        return left;
    }
}
