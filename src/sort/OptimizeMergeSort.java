package sort;

import sort.common.ISortingAlgorithm;

/**
 * @author AhogeK
 * @since 2025-03-05 15:06:01
 */
public class OptimizeMergeSort implements ISortingAlgorithm {

    /**
     * 列表大小等于或小于该大小，将优先于归并排序使用插入排序
     */
    private static final int INSERTION_SORT_THRESHOLD = 47;

    @Override
    public void sortArray(int[] nums) {
        int len = nums.length;

        // 优化3：全局使用一份临时数组
        int[] temp = new int[len];
        mergeSort(nums, 0, len - 1, temp);
    }

    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        // 优化1：小区间使用插入排序
        if (right - left <= INSERTION_SORT_THRESHOLD) {
            insertionSort(nums, left, right);
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);

        // 优化2：数组已经有序的情况下，不再合并
        if (nums[mid] <= nums[mid + 1]) return;
        mergeOfTwoSortedArray(nums, left, mid, right, temp);
    }

    private void mergeOfTwoSortedArray(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) temp[i] = nums[i];

        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) nums[k] = temp[j++];
            else if (j == right + 1) nums[k] = temp[i++];
            // 注意：这里一定要写成 <=，否则就变成了非稳定排序
            else if (temp[i] <= temp[j]) nums[k] = temp[i++];
            else nums[k] = temp[j++];
        }
    }

    private void insertionSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = nums[i];
            int j = i;
            while (j > left && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }
}
