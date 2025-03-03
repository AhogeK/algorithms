package sort;

import sort.common.ISortingAlgorithm;

/**
 * 归并排序
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-02-28 13:38:09
 */
public class MergeSort implements ISortingAlgorithm {

    @Override
    public void sortArray(int[] nums) {
        int len = nums.length;
        mergeSort(nums, 0, len - 1);
    }

    /**
     * 归并排序, 对数组 nums 的 [left, right] 区间进行排序
     *
     * @param nums  待排序数组
     * @param left  左边界
     * @param right 右边界
     */
    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        mergeOfTwoSortedArray(nums, left, mid, right);
    }

    /**
     * 合并两个有序数组
     *
     * @param nums  待排序数组
     * @param left  左边界
     * @param mid   中间值
     * @param right 右边界
     */
    private void mergeOfTwoSortedArray(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        System.arraycopy(temp, 0, nums, left, temp.length);
    }

    @Override
    public String toString() {
        return "归并排序";
    }
}
